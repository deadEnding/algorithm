package leetcode.again.L465_OptimalAccountBalancing;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author: deadend
 * @date: 2:35 PM 3/14/17
 * @version: 1.0
 * @description:
 */


// Timeout
public class Solution {
    private int helper(int ix, ArrayList<Integer> nums) {
        System.out.println(ix);
        if (ix == nums.size()) {
            return 0;
        }

        if (nums.get(ix) == 0) {
            return helper(ix + 1, nums);
        }

        int min = Integer.MAX_VALUE;
        int p = nums.get(ix);
        for (int i = ix + 1; i < nums.size(); i++) {
            int q = nums.get(i);
            if (p < 0 && q > 0 || p > 0 && q < 0) {
                nums.set(i, p + q);
                min = Math.min(min, helper(ix + 1, nums) + 1);
                nums.set(i, q);
            }
        }
        return min;
    }

    public int minTransfers(int[][] transactions) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] t : transactions) {
            map.put(t[0], map.getOrDefault(t[0], 0) - t[2]);
            map.put(t[1], map.getOrDefault(t[1], 0) + t[2]);
        }

        ArrayList<Integer> nums = new ArrayList<>(map.size());
        for (int val : map.values()) {
            if (val != 0) {
                nums.add(val);
            }
        }
        return helper(0, nums);
    }

    public static void main(String[] args) {
//        int[][] t = {{0,1,1},{1,2,1},{2,3,4},{3,4,5}};
//        int[][] t = {{1,5,8},{8,9,8},{2,3,9},{4,3,1}};
        int[][] t = {{1,8,1},{1,13,21},{2,8,10},{3,9,20},{4,10,61},{5,11,61},{6,12,59},{7,13,60}};
        System.out.println(new Solution().minTransfers(t));
    }
}

package leetcode.L047_PermutationsII;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 8:11 PM 11/30/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    private List<List<Integer>> result = new LinkedList<>();


    private void permuteUnique(int[] nums, LinkedList<Integer> path, HashMap<Integer, Integer> map) {
        if (path.size() == nums.length) {
            result.add(new LinkedList<>(path));
            return;
        }

        for (int key : map.keySet()) {
            int val = map.get(key);
            if (val > 0) {
                path.addLast(key);
                map.put(key, val - 1);
                permuteUnique(nums, path, map);
                map.put(key, val);
                path.removeLast();
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.containsKey(n) ? map.get(n) + 1 : 1);
        }
        permuteUnique(nums, new LinkedList<Integer>(), map);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        List<List<Integer>> result = new Solution().permuteUnique(nums);
        for (List<Integer> list : result) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
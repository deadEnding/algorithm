package leetcode.L496_NextGreaterElementI;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 11:08 AM 2/11/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int fn : findNums) {
            map.put(fn, -1);
        }

        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                int top = stack.pop();
                if (map.containsKey(top)) {
                    map.put(top, nums[i]);
                }
            }
            stack.push(nums[i]);
        }

        int[] result = new int[findNums.length];
        for (int i = 0; i < findNums.length; i++) {
            result[i] = map.get(findNums[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] findNums = {4,1,2};
        int[] nums = {1,3,4,2};
        int[] result = new Solution().nextGreaterElement(findNums, nums);
        for (int r : result) {
            System.out.print(r + ",");
        }
    }
}

package leetcode.L503_NextGreaterElementII;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 4:15 PM 28/03/2017
 */


public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        final int n = nums.length;
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = n - 1; i >= 0; i--) {
            stack.push(nums[i]);
        }

        int[] nexts = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }

            nexts[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return nexts;
    }
}

package leetcode.L503_NextGreaterElementII;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 1:43 PM 2/11/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        final int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        LinkedList<Integer> stack = new LinkedList<>();
        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                    result[stack.pop()] = nums[i];
                }
                stack.push(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int[] result = new Solution().nextGreaterElements(nums);
        for (int r : result) {
            System.out.print(r + ",");
        }
    }
}

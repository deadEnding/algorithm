package leetcode.L238_ProductOfArrayExceptSelf;

/**
 * @author: deadend
 * @date: 9:44 AM 11/23/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int[] productExceptSelf(int[] nums) {
        final int n = nums.length;
        int[] result = new int[n];
        if (n == 0) {
            return result;
        }

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = right[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
            right[n - 1 - i] = right[n - i] * nums[n - i];
        }

        for (int i = 0; i < n; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {};
        int[] result = new Solution().productExceptSelf(nums);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
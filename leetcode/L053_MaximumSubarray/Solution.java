package leetcode.L053_MaximumSubarray;

/**
 * @author: deadend
 * @date: 12:51 PM 11/14/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int maxSubArray(int[] nums) {
        int b = nums[0];
        int max = b;
        for (int i = 1; i < nums.length; i++) {
            b = b > 0 ? b + nums[i] : nums[i];
            max = Math.max(max, b);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {4};
        System.out.println(new Solution().maxSubArray(nums));
    }
}

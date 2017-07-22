package leetcode.again.L053_MaximumSubarray;


public class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int dp = 0;
        for (int num : nums) {
            dp = Math.max(dp + num, num);
            max = Math.max(max, dp);
        }

        return max;
    }
}

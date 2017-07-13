package leetcode.again.L416_PartitionEqualSubsetSum;

/**
 * @author: deadend
 * @date: 7:26 PM 3/2/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public boolean canPartition(int[] nums) {
        final int n = nums.length;
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % 2 == 1)
            return false;

        int c = sum / 2;
        int[] dp = new int[c + 1];
        for (int i = 0; i < n; i++) {
            for (int j = c; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[c] == c;
    }
}

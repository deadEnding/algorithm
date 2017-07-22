package leetcode.L377_CombinationSumIV;

/**
 * @author: deadend
 * @date: 10:35 AM 3/20/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i - num >= 0) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}

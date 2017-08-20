package leetcode.L312_BurstBalloons;


public class Solution {
    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            arr[i + 1] = nums[i];
        }
        arr[0] = arr[nums.length + 1] = 1;

        final int n = arr.length;
        int[][] dp = new int[n][n];
        for (int d = 2; d < n; d++) {
            for (int i = 0; i + d < n; i++) {
                int j = i + d;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + arr[i] * arr[k] * arr[j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}

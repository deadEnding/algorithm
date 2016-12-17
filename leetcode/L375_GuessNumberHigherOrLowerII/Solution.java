package leetcode.L375_GuessNumberHigherOrLowerII;

/**
 * @author: deadend
 * @date: 11:24 PM 12/17/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    private int payForRange(int[][] dp, int s, int e) {
        if (s >= e) {
            return 0;
        }

        if (dp[s][e] == 0) {
            dp[s][e] = Integer.MAX_VALUE;
            for (int i = s; i <= e; i++) {
                int max = i + Math.max(payForRange(dp, s, i - 1), payForRange(dp, i + 1, e));
                dp[s][e] = Math.min(dp[s][e], max);
            }
        }
        return dp[s][e];
    }

    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return payForRange(dp, 1, n);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getMoneyAmount(10));
    }
}

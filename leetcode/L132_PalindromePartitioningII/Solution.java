package leetcode.L132_PalindromePartitioningII;

/**
 * @author: deadend
 * @date: 6:29 PM 3/4/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int minCut(String s) {
        final int n = s.length();

        int[] dp = new int[n + 1];
        dp[n] = -1;
        boolean[][] isPali = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = -1;
            for (int j = i; j < n; j++) {
                isPali[i][j] = (s.charAt(i) == s.charAt(j) && (i + 1 >= j || isPali[i + 1][j - 1]));
                if (isPali[i][j] && (dp[i] == -1 || dp[j + 1] + 1 < dp[i])) {
                    dp[i] = dp[j + 1] + 1;
                }
            }
        }
        return dp[0];
    }
}

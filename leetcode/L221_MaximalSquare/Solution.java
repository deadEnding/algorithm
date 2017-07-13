package leetcode.L221_MaximalSquare;

/**
 * @author: deadend
 * @date: P10:19 PM 12/9/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        final int m = matrix.length;
        final int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j], dp[i + 1][j]), dp[i][j + 1]) + 1;
                } else {
                    dp[i + 1][j + 1] = 0;
                }
                max = Math.max(max, dp[i + 1][j + 1]);
            }
        }
        return max * max;
    }
}
package leetcode.L568_MaximumVacationDays;

import java.util.Arrays;

public class Solution {

    public int maxVacationDays(int[][] flights, int[][] days) {
        final int n = flights.length, k = days[0].length;
        int[][] dp = new int[k + 1][n];

        int max = 0;
        for (int i = 0; i <= k; i++) {
            Arrays.fill(dp[i], -1);
        }

        dp[0][0] = 0;
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    if ((j == l || flights[l][j] == 1) && dp[i - 1][l] != -1) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][l] + days[j][i - 1]);
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] f = {{0,1,1},{1,0,1},{1,1,0}};
        int[][] d = {{1,3,1},{6,0,3},{3,3,3}};
        System.out.println(new Solution().maxVacationDays(f, d));
    }
}

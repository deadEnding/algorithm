package leetcode.again.L576_OutOfBoundaryPaths;


public class Solution {
    private static final int MOD = 1000000007;

    public int findPaths(int m, int n, int N, int i, int j) {
        int[][][] dp = new int[2][m][n];
        for (int s = 1; s <= N; s++) {
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    dp[s % 2][r][c] = 0;
                    dp[s % 2][r][c] = (dp[s % 2][r][c] + (r == 0 ? 1 : dp[(s - 1) % 2][r - 1][c])) % MOD;
                    dp[s % 2][r][c] = (dp[s % 2][r][c] + (r == m - 1 ? 1 : dp[(s - 1) % 2][r + 1][c])) % MOD;
                    dp[s % 2][r][c] = (dp[s % 2][r][c] + (c == 0 ? 1 : dp[(s - 1) % 2][r][c - 1])) % MOD;
                    dp[s % 2][r][c] = (dp[s % 2][r][c] + (c == n - 1 ? 1 : dp[(s - 1) % 2][r][c + 1])) % MOD;
                }
            }
        }

        return dp[N % 2][i][j];
    }
}

class BasicSolution {
    private static final int MOD = 1000000007;

    public int findPaths(int m, int n, int N, int i, int j) {
        int[][][] dp = new int[N + 1][m][n];

        for (int s = 1; s <= N; s++) {
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    dp[s][r][c] = (dp[s][r][c] + (r == 0 ? 1 : dp[s - 1][r - 1][c])) % MOD;
                    dp[s][r][c] = (dp[s][r][c] + (r == m - 1 ? 1 : dp[s - 1][r + 1][c])) % MOD;
                    dp[s][r][c] = (dp[s][r][c] + (c == 0 ? 1 : dp[s - 1][r][c - 1])) % MOD;
                    dp[s][r][c] = (dp[s][r][c] + (c == n - 1 ? 1 : dp[s - 1][r][c + 1])) % MOD;
                }
            }
        }

        return dp[N][i][j];
    }
}

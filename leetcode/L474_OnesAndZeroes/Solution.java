package leetcode.L474_OnesAndZeroes;

/**
 * @author: deadend
 * @date: 2:51 PM 3/2/17
 * @version: 1.0
 * @description:
 */


class Solution {
    private int[] count(String s) {
        final int n = s.length();
        int ones = 0;
        for (char c : s.toCharArray()) {
            ones += c - '0';
        }
        return new int[] {n - ones, ones};
    }

    public int findMaxForm(String[] strs, int m, int n) {
        final int l = strs.length;
        int[][][] dp = new int[2][m + 1][n + 1];
        for (int i = 0; i < l; i++) {
            int[] cnt = count(strs[i]);
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (cnt[0] <= j && cnt[1] <= k) {
                        dp[(i + 1) % 2][j][k] = Math.max(dp[i % 2][j][k], dp[i % 2][j - cnt[0]][k - cnt[1]] + 1);
                    } else {
                        dp[(i + 1) % 2][j][k] = dp[i % 2][j][k];
                    }
                }
            }
        }

        return dp[l % 2][m][n];
    }
}


class OldSolution {
    private int[] count(String s) {
        int[] cnt = new int[2];
        for (char c : s.toCharArray()) {
            cnt[c - '0']++;
        }
        return cnt;
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            int[] cnt = count(s);
            for (int i = m; i >= cnt[0]; i--) {
                for (int j = n; j >= cnt[1]; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - cnt[0]][j - cnt[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }
}

class OldBasicSolution {
    private int[] count(String s) {
        int[] cnt = new int[2];
        for (char c : s.toCharArray()) {
            cnt[c - '0']++;
        }
        return cnt;
    }

    public int findMaxForm(String[] strs, int m, int n) {
        final int l = strs.length;
        int[][][] dp = new int[l + 1][m + 1][n + 1];

        for (int i = 1; i <= l; i++) {
            int[] cnt = count(strs[i - 1]);
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (cnt[0] <= j && cnt[1] <= k) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - cnt[0]][k- cnt[1]] + 1);
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }
        return dp[l][m][n];
    }
}

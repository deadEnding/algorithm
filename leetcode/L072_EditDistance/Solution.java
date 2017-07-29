package leetcode.L072_EditDistance;

/**
 * @author: deadend
 * @date: P10:50 AM 2/28/17
 * @version: 1.0
 * @description:
 */

public class Solution {
    public int minDistance(String word1, String word2) {
        final int n1 = word1.length();
        final int n2 = word2.length();

        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int j = 0; j <= n2; j++) {
            dp[0][j] = j;
        }

        for (int i = 0; i <= n1; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i][j + 1], dp[i + 1][j])) + 1;
                }
            }
        }

        return dp[n1][n2];
    }
}


class OldSolution {
    public int minDistance(String word1, String word2) {
        final int m = word1.length();
        final int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int rep = (word1.charAt(i) == word2.charAt(j) ? 0 : 1) + dp[i][j];
                dp[i + 1][j + 1] = Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]) + 1, rep);
            }
        }
        return dp[m][n];
    }
}

class BasicSolution {
    public int minDistance(String word1, String word2) {
        final int n1 = word1.length();
        final int n2 = word2.length();

        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 0; i <= n1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n2; j++) {
            dp[0][j] = j;
        }

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i][j + 1], dp[i + 1][j])) + 1;
                }
            }
        }
        return dp[n1][n2];
    }
}

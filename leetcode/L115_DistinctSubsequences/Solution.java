package leetcode.L115_DistinctSubsequences;

/**
 * @author: deadend
 * @date: 4:41 PM 3/4/17
 * @version: 1.0
 * @description:
 */

public class Solution {
    public int numDistinct(String s, String t) {
        final int m = s.length(), n = t.length();

        int[][] dp = new int[2][n + 1];
        dp[0][0] = dp[1][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[(i + 1) % 2][j + 1] = dp[i % 2][j + 1] + (s.charAt(i) == t.charAt(j) ? dp[i % 2][j] : 0);
            }
        }

        return dp[m % 2][n];
    }
}

class BasicSolution {
    public int numDistinct(String s, String t) {
        final int m = s.length(), n = t.length();

        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                dp[j + 1] += s.charAt(i) == t.charAt(j) ? dp[j] : 0;
            }
        }

        return dp[n];
    }
}

class DPSolution {
    public int numDistinct(String s, String t) {
        final int m = s.length(), n = t.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i + 1][j + 1] = dp[i][j + 1] + (s.charAt(i) == s.charAt(j) ? dp[i][j] : 0);
            }
        }

        return dp[m][n];
    }
}


class OldSolution {
    public int numDistinct(String s, String t) {
        final int m = s.length();
        final int n = t.length();

        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = n; j >= 1; j--) {
                dp[j] += (s.charAt(i - 1) == t.charAt(j - 1) ? dp[j - 1] : 0);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String s = "tttt";
        String t = "tt";
        System.out.println(new Solution().numDistinct(s, t));
    }
}

package leetcode.L516_LongestPalindromicSubsequence;

/**
 * @author: deadend
 * @date: 2:59 PM 2/11/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    private int lps(String s, int i ,int j, Integer[][] mem) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return 1;
        }

        if (mem[i][j] == null) {
            if (s.charAt(i) == s.charAt(j)) {
                mem[i][j] = lps(s, i + 1, j - 1, mem) + 2;
            } else {
                mem[i][j] = Math.max(lps(s, i, j - 1, mem), lps(s, i + 1, j, mem));
            }
        }
        return mem[i][j];
    }

    public int longestPalindromeSubseq(String s) {
        final int n = s.length();
        return lps(s, 0, n - 1, new Integer[n][n]);
    }

    public static void main(String[] args) {
        String s = "";
        System.out.println(new Solution().longestPalindromeSubseq(s));
    }
}

class OtherSolution {
    public int longestPalindromeSubseq(String s) {
        final int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}

package leetcode.L005_LongestPalindromicSubstring;

/**
 * @author: deadend
 * @date: 9:19 AM 2/27/17
 * @version: 1.0
 * @description:
 */

/**
 * f[i][j]
 *      = true, i == j
 *      = s[i] == s[j], i + 1 == j
 *      = s[i] == s[j] && f[i + 1][j - 1], other
 */

public class Solution {
    public String longestPalindrome(String s) {
        final int n = s.length();

        boolean[][] isPali = new boolean[n][n];
        int start = 0, maxLen = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                isPali[i][j] = s.charAt(i) == s.charAt(j) && (i + 1 >= j || isPali[i + 1][j - 1]);
                if (isPali[i][j] && j - i + 1 > maxLen) {
                    start = i;
                    maxLen = j - i + 1;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(new Solution().longestPalindrome(s));
    }
}

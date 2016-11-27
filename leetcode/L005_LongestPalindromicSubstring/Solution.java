package leetcode.L005_LongestPalindromicSubstring;

/**
 * @author: deadend
 * @date: 10:31 AM 11/27/16
 * @version: 1.0
 * @description:
 */

public class Solution {
    public String longestPalindrome(String s) {
        final int n = s.length();
        boolean[][] isPali = new boolean[n][n];
        int start = 0;
        int maxLen = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                isPali[i][j] = (s.charAt(i) == s.charAt(j) && (j - i <= 1 ? true : isPali[i+1][j-1]));
                if (isPali[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        String s = "aaaa";
        System.out.println(new Solution().longestPalindrome(s));
    }
}

class BasicSolution {
    public String longestPalindrome(String s) {
        final int n = s.length();
        int start = 0;
        int maxLen = 0;
        for (int i = 0; i < 2 * n - 1; i++) {
            int a, b;
            if (i % 2 == 1) {   // 空隙
                a = i / 2;
                b = (i + 1) / 2;
            } else {
                a = i / 2 - 1;
                b = i / 2 + 1;
            }
            while (a >= 0 && b < n && s.charAt(a) == s.charAt(b)) {
                a--;
                b++;
            }
            if (b - a - 1 > maxLen) {
                maxLen = b - a - 1;
                start = a + 1;
            }
        }
        return s.substring(start, start + maxLen);
    }
}

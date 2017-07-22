package leetcode.L044_WildcardMatching;

/**
 * @author: deadend
 * @date: 11:09 AM 3/18/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public boolean isMatch(String s, String p) {
        final int m = s.length(), n = p.length();
        boolean[][] match = new boolean[m + 1][n + 1];

        match[0][0] = true;
        for (int j = 1; j <= n; j++) {
            match[0][j] = match[0][j - 1] && p.charAt(j - 1) == '*';
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    match[i][j] = match[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    match[i][j] = match[i][j - 1] | match[i - 1][j];
                } else {
                    match[i][j] = false;
                }
            }
        }
        return match[m][n];
    }

    public static void main(String[] args) {
        String s = "";
        String p = "*";
        System.out.println(new Solution().isMatch(s, p));
    }
}

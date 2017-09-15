package leetcode.L010_RegularExpressionMatching;


public class Solution {
    public boolean isMatch(String s, String p) {
        final int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;
        for (int i = 0; i < n; i++) {
            dp[0][i + 1] = p.charAt(i) == '*' && dp[0][i - 1];
        }

        for (int i = 0; i < m; i++) {
            char sc = s.charAt(i);
            for (int j = 0; j < n; j++) {
                char pc = p.charAt(j);
                if (pc == '.' || sc == pc) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (pc == '*') {
                    if (s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                        dp[i + 1][j + 1] = dp[i][j + 1] | dp[i][j - 1] | dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    }
                }
            }
        }

        return dp[m][n];
    }
}

class TimeoutSolution {
    public boolean isMatch(String s, String p) {
        System.out.println(s + "    " + p);
        if (s.equals("") && p.equals("")) {
            return true;
        }

        if (!s.equals("") && p.equals("")) {
            return false;
        }

        if (s.equals("") && !p.equals("")) {
            return p.length() > 1 && p.charAt(1) == '*' && isMatch(s, p.substring(2));
        }

        if (p.length() > 1 && p.charAt(1) == '*') {
            if (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0)) {
                return isMatch(s, p.substring(2)) || isMatch(s.substring(1), p);
            } else {
                return isMatch(s, p.substring(2));
            }
        } else {
            return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
        }
    }

    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaab";
        String p = "a*a*a*a*a*a*a*a*a*a*c";
        System.out.println(new Solution().isMatch(s, p));
    }
}

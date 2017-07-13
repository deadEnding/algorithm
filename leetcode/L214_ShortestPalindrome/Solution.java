package leetcode.L214_ShortestPalindrome;

/**
 * @author: deadend
 * @date: 2:P10 PM 12/9/16
 * @version: 1.0
 * @description:
 */

public class Solution {
    public String shortestPalindrome(String s) {
        String rs = new StringBuffer(s).reverse().toString();
        String ns = s + "#" + rs;
        int[] next = new int[ns.length()];
        for (int i = 1; i < ns.length(); i++) {
            int j = next[i - 1];
            while (j > 0 && ns.charAt(i) != ns.charAt(j)) {
                j = next[j - 1];
            }
            j += ns.charAt(i) == ns.charAt(j) ? 1 : 0;
            next[i] = j;
        }
        return rs.substring(0, s.length() - next[ns.length() - 1]) + s;
    }

    public static void main(String[] args) {
        String s = "acaa";
        System.out.println(new Solution().shortestPalindrome(s));
    }
}

class BasicSolution {
    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public String shortestPalindrome(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            if (isPalindrome(s, 0, i)) {
                return new StringBuffer(s.substring(i + 1)).reverse().toString() + s;
            }
        }
        return "";
    }
}

class ExceedMemeoryLimitSolution {
    public String shortestPalindrome(String s) {
        final int n = s.length();
        boolean[][] isPali = new boolean[n][n];

        int lenMax = 0;
        for (int j = 0; j < n; j++) {
            for (int i = j; i >= 0; i--) {
                isPali[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i <= 1 || isPali[i + 1][j - 1]);
            }
            lenMax = Math.max(lenMax, isPali[0][j] ? j + 1 : 0);
        }

        StringBuffer sb = new StringBuffer();
        for (int i = n - 1; i >= lenMax; i--) {
            sb.append(s.charAt(i));
        }
        sb.append(s);
        return sb.toString();
    }
}

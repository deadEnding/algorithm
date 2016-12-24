package leetcode.L459_RepeatedSubstringPattern;

/**
 * @author: deadend
 * @date: 2:31 PM 12/24/16
 * @version: 1.0
 * @description:
 */

public class Solution {
    private boolean isMatch(String str, int len) {
        for (int i = len; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i - len)) {
                return false;
            }
        }
        return true;
    }

    public boolean repeatedSubstringPattern(String str) {
        final int n = str.length();

        for (int i = 1; i <= n / 2; i++) {
            if (n % i != 0 || str.charAt(i - 1) != str.charAt(n - 1)) {
                continue;
            }
            if (isMatch(str, i)) {
                return true;
            }
        }
        return false;
    }
}

class BasicSolution {
    private boolean match(String str, int from) {
        if (str.length() % from != 0) {
            return false;
        }
        for (int i = from; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i - from)) {
                return false;
            }
        }
        return true;
    }

    public boolean repeatedSubstringPattern(String str) {
        if (str.length() <= 1) {
            return false;
        }

        char lastc = str.charAt(str.length() - 1);
        int ix = str.indexOf(lastc);
        while (0 <= ix && ix < str.length() - 1) {
            if (match(str, ix + 1)) {
                return true;
            }
            ix = str.indexOf(lastc, ix + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(new Solution().repeatedSubstringPattern(s));
    }
}

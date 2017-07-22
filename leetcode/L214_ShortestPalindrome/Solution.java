package leetcode.L214_ShortestPalindrome;

/**
 * @author: deadend
 * @date: 4:26 PM 3/15/17
 * @version: 1.0
 * @description:
 */


class TimeoutSolution {
    private boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public String shortestPalindrome(String s) {
        final int n = s.length();
        for (int i = n; i > 0; i--) {
            if (isPalindrome(s.substring(0, i))) {
                s = new StringBuilder().append(s.substring(i)).reverse().toString() + s;
                break;
            }
        }
        return s;
    }
}

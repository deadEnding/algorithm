package leetcode.L044_WildcardMatching;

/**
 * @author: deadend
 * @date: 3:07 PM 11/30/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0;
        int bi = -1, bj = -1;
        while (i < s.length()) {
            if (j == p.length()) {
                if (bj != -1) {
                    i = ++bi;
                    j = bj + 1;
                    continue;
                } else {
                    return false;
                }
            }
            char sc = s.charAt(i);
            char pc = p.charAt(j);
            if (pc == '?' || pc == sc) {
                i++;
                j++;
            } else if (pc == '*') {
                bi = i;
                bj = j++;
                if (j == p.length()) {
                    return true;
                }
            } else if (bj != -1) {
                i = ++bi;
                j = bj + 1;
            } else {
                return false;
            }
        }

        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }
        return j == p.length();
    }

    public static void main(String[] args) {
        String s = "aa";
        String p = "a";
        System.out.println(new Solution().isMatch(s, p));
    }
}

package leetcode.L392_IsSubsequence;

/**
 * @author: deadend
 * @date: P10:36 PM 1/8/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public boolean isSubsequence(String s, String t) {
        int ix = 0;
        for (int i = 0; i < t.length(); i++) {
            if (ix == s.length()) {
                return true;
            }
            if (t.charAt(i) == s.charAt(ix)) {
                ix++;
            }
        }
        return ix == s.length();
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "aaabc";
        System.out.println(new Solution().isSubsequence(s, t));
    }
}

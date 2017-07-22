package leetcode.L392_IsSubsequence;

/**
 * @author: deadend
 * @date: 4:54 PM 3/1/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public boolean isSubsequence(String s, String t) {
        int j = 0;
        for (int i = 0; i < t.length(); i++) {
            if (j == s.length()) {
                break;
            }
            if (t.charAt(i) == s.charAt(j)) {
                j++;
            }
        }
        return j == s.length();
    }
}

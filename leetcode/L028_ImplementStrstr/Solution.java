package leetcode.L028_ImplementStrstr;

/**
 * @author: deadend
 * @date: P10:31 AM 11/30/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int strStr(String haystack, String needle) {
        final int m = haystack.length();
        final int n = needle.length();
        for (int i = 0; i + n <= m; i++) {
            boolean found = true;
            for (int j = 0; j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    found = false;
                    break;
                }
            }

            if (found) {
                return i;
            }
        }
        return -1;
    }
}

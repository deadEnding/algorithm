package leetcode.again.L028_ImplementStrstr;


public class Solution {
    public int strStr(String haystack, String needle) {
        final int m = haystack.length();
        final int n = needle.length();

        for (int i = 0; i <= m - n; i++) {
            boolean found = true;
            for (int j = 0; j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    found = false;
                    break;
                }
            }

            if (found)
                return i;
        }

        return -1;
    }
}

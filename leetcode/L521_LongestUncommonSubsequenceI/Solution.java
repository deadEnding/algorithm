package leetcode.L521_LongestUncommonSubsequenceI;

/**
 * Created by deadend on 30/10/2017.
 */

class Solution {
    public int findLUSlength(String a, String b) {
        final int m = a.length(), n = b.length();
        if (a.equals(b)) {
            return -1;
        }

        return m >= n ? m : n;
    }
}

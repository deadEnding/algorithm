package leetcode.L091_DecodeWays;

/**
 * @author: deadend
 * @date: 9:39 AM 12/2/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int numDecodings(String s) {
        final int n = s.length();
        if (n == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int prev = 1, curr = 1;
        for (int i = 1; i < n; i++) {
            int cv = Integer.valueOf(s.substring(i, i + 1));
            if (cv == 0) {
                curr = 0;
            }

            int bv = Integer.valueOf(s.substring(i - 1, i + 1));
            if (bv < 10 || bv > 26) {
                prev = 0;
            }

            int tmp = curr;
            curr += prev;
            prev = tmp;
        }
        return curr;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("12"));
    }
}

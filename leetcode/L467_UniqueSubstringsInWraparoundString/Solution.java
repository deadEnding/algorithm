package leetcode.L467_UniqueSubstringsInWraparoundString;

import java.util.HashSet;

/**
 * @author: deadend
 * @date: 4:45 PM 12/24/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int findSubstringInWraproundString(String p) {
        int[] count = new int[26];

        for (int i = 0, len = 1; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i - 1) - 'a' + 1) % 26 + 1 == (p.charAt(i) - 'a' + 1)) {
                len++;
            } else {
                len = 1;
            }

            int ix = p.charAt(i) - 'a';
            count[ix] = Math.max(count[ix], len);
        }

        int sum = 0;
        for (int c : count) {
            sum += c;
        }
        return sum;
    }

    public static void main(String[] args) {
        String p = "a";
        System.out.println(new Solution().findSubstringInWraproundString(p));
    }
}

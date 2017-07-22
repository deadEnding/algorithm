package leetcode.again.L467_UniqueSubstringsInWraparoundString;

/**
 * @author: deadend
 * @date: 1:28 PM 3/2/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int findSubstringInWraproundString(String p) {
        int[] count = new int[26];

        for (int i = 0, len = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (i == 0 || p.charAt(i - 1) + 1 == c || p.charAt(i - 1) == c + 25) {
                len++;
            } else {
                len = 1;
            }

            count[c - 'a'] = Math.max(count[c - 'a'], len);
        }

        int sum = 0;
        for (int c : count) {
            sum += c;
        }
        return sum;
    }

    public static void main(String[] args) {
        String p = "cac";
        System.out.println(new Solution().findSubstringInWraproundString(p));
    }
}

package leetcode.L434_NumberOfSegmentsInAString;

/**
 * @author: deadend
 * @date: 8:35 PM 12/22/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int countSegments(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && (i + 1 == s.length() || s.charAt(i + 1) == ' ')) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "";
        System.out.println(new Solution().countSegments(s));
    }
}

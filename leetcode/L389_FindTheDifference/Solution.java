package leetcode.L389_FindTheDifference;

/**
 * @author: deadend
 * @date: P10:38 PM 11/25/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public char findTheDifference(String s, String t) {
        long c = 0L;
        for (int i = 0; i < t.length(); i++) {
            c += t.charAt(i);
        }

        for (int i = 0; i < s.length(); i++) {
            c -= s.charAt(i);
        }
        return (char) c;
    }
}

package leetcode.L409_LongestPalindrome;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: 10:39 PM 11/25/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
            if (map.get(c) % 2 == 0) {
                count += 2;
            }
        }

        return count == s.length() ? count : count + 1;
    }
}

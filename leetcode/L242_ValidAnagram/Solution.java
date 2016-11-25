package leetcode.L242_ValidAnagram;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: 1:37 PM 11/25/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            map.put(sc, map.containsKey(sc) ? map.get(sc) + 1 : 1);
            map.put(tc, map.containsKey(tc) ? map.get(tc) - 1 : -1);
        }

        for (int c : map.values()) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}

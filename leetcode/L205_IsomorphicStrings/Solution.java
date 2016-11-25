package leetcode.L205_IsomorphicStrings;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: 1:09 PM 11/25/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (map.containsKey(sc)) {
                if (tc != map.get(sc)) {
                    return false;
                }
            } else {
                if (map.containsValue(tc)) {
                    return false;
                } else {
                    map.put(sc, tc);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isIsomorphic("aa", "ab"));
    }
}

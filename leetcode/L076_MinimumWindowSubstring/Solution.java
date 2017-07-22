package leetcode.L076_MinimumWindowSubstring;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: 1:01 PM 3/4/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public String minWindow(String s, String t) {
        if (s.equals("") || t.equals("")) {
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        String result = null;
        int count = t.length();
        for (int i = 0, start = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0) {
                    count--;
                }
            }

            while (count == 0) {
                if (result == null || result.length() > i - start + 1) {
                    result = s.substring(start, i + 1);
                }

                char bc = s.charAt(start++);
                if (map.containsKey(bc)) {
                    map.put(bc, map.get(bc) + 1);
                    if (map.get(bc) > 0) {
                        count++;
                    }
                }
            }
        }
        return result == null ? "" : result;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "";
        System.out.println(new Solution().minWindow(s, t));
    }
}

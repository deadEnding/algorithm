package leetcode.L076_MinimumWindowSubstring;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author: deadend
 * @date: 5:01 PM 11/24/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tmap.put(c, tmap.containsKey(c) ? tmap.get(c) + 1 : 1);
        }

        String result = "";
        for (int r = 0, l = 0, count = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (tmap.containsKey(c)) {
                tmap.put(c, tmap.get(c) - 1);
                count += tmap.get(c) >= 0 ? 1 : 0;

                while (count == t.length()) {
                    if (result.equals("") || result.length() > r - l + 1) {
                        result = s.substring(l, r + 1);
                    }

                    char lc = s.charAt(l);
                    if (tmap.containsKey(lc)) {
                        tmap.put(lc, tmap.get(lc) + 1);
                        count -= tmap.get(lc) > 0 ? 1 : 0;
                    }
                    l++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(new Solution().minWindow(s,t));
    }
}

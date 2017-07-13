package leetcode.again.L159_LongestSubstringWithAtMostTwoDistinctCharacters;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: 7:28 PM 3/11/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0, start = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.size() > 2) {
                char sc = s.charAt(start++);
                map.put(sc, map.get(sc) - 1);
                if (map.get(sc) == 0) {
                    map.remove(sc);
                }
            }
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}

package leetcode.L340_LongestSubstringWithAtMostKDistinctCharacters;

import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                while (map.size() == k) {
                    char lc = s.charAt(l++);
                    if (map.get(lc) == 1) {
                        map.remove(lc);
                    } else {
                        map.put(lc, map.get(lc) - 1);
                    }
                }

                map.put(c, 1);
            }
            max = Math.max(max, r - l + 1);
        }

        return max;
    }
}


class OtherSolution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0)
            return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int l = 0, r = 0; l < s.length(); l++) {
            while (r < s.length() && map.size() + (map.containsKey(s.charAt(r)) ? 0 : 1) <= k) {
                char c = s.charAt(r++);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            max = Math.max(max, r - l);

            char c = s.charAt(l);
            int cnt = map.get(c);
            if (cnt == 1) {
                map.remove(c);
            } else {
                map.put(c, cnt - 1);
            }
        }

        return max;
    }
}

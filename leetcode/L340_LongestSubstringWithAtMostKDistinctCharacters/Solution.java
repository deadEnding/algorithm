package leetcode.L340_LongestSubstringWithAtMostKDistinctCharacters;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: 9:14 PM 3/9/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }

        HashMap<Character, Integer> counter = new HashMap<>();
        int max = 0;
        for (int i = 0, from = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (counter.containsKey(c)) {
                counter.put(c, counter.get(c) + 1);
            } else {
                while (counter.size() == k) {
                    char cs = s.charAt(from++);
                    if (counter.get(cs) == 1) {
                        counter.remove(cs);
                    } else {
                        counter.put(cs, counter.get(cs) - 1);
                    }
                }
                counter.put(c, 1);
            }
            max = Math.max(max, i - from + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstringKDistinct("eceba", 2));
    }
}

package leetcode.L409_LongestPalindrome;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: 7:51 PM 3/17/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int longestPalindrome(String s) {
        int count = 0;
        HashMap<Character, Integer> counter = new HashMap<>();

        for (char c : s.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
            if (counter.get(c) % 2 == 0) {
                count += 2;
            }
        }

        return count == s.length() ? count : count + 1;
    }
}

class BasicSolution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> counter = new HashMap<>();
        for (char c : s.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }

        int count = 0;
        boolean hasOdd = false;
        for (int val : counter.values()) {
            if (val % 2 == 0) {
                count += val;
            } else {
                count += val - 1;
                hasOdd = true;
            }
        }
        return count + (hasOdd ? 1 : 0);
    }
}

package leetcode.again.L003_LongestSubstringWithoutRepeatingCharacters;


import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> visited = new HashMap<>();
        int max = 0;
        for (int i = 0, start = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (visited.containsKey(c) && visited.get(c) >= start) {
                start = visited.get(c) + 1;
            }

            visited.put(c, i);
            max = Math.max(max, i - start + 1);
        }

        return max;
    }
}

class BasicSolution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> visited = new HashSet<>();
        int max = 0;
        for (int i = 0, start = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (visited.contains(c)) {
                while (s.charAt(start) != c) {
                    visited.remove(s.charAt(start++));
                }
                start++;
            } else {
                visited.add(c);
            }

            max = Math.max(max, i - start + 1);
        }

        return max;
    }
}

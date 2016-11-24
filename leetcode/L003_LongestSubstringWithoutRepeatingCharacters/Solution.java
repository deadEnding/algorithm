package leetcode.L003_LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: 1:15 PM 11/24/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> index = new HashMap<>();   // 长度256的数组亦可

        int max = 0;
        for (int i = 0, start = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (index.containsKey(c) && index.get(c) >= start) {
                start = index.get(c) + 1;
            }
            index.put(c, i);
            max = Math.max(max, i - start + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "123456JKL:";
        System.out.println(new Solution().lengthOfLongestSubstring(s));
    }
}

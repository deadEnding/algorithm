package leetcode.L424_LongestRepeatingCharacterReplacement;

/**
 * @author: deadend
 * @date: 5:22 PM 3/1/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;
        int maxCount = 0;
        int[] counter = new int[26];
        for (int i = 0, start = 0; i < s.length(); i++) {
            maxCount = Math.max(maxCount, ++counter[s.charAt(i) - 'A']);
            if (i - start + 1 - maxCount > k) {
                counter[s.charAt(start++) - 'A']--;
            }
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}


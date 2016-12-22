package leetcode.L424_LongestRepeatingCharacterReplacement;

/**
 * @author: deadend
 * @date: 1:46 PM 12/22/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;
        int maxCount = 0;
        int[] counter = new int[26];
        for (int start = 0, end = 0; end < s.length(); end++) {
            maxCount = Math.max(maxCount, ++counter[s.charAt(end) - 'A']);
            if (end - start + 1 - maxCount > k) {
                counter[s.charAt(start++) - 'A']--;
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}

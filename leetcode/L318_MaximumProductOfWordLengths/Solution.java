package leetcode.L318_MaximumProductOfWordLengths;

/**
 * @author: deadend
 * @date: 9:44 AM 3/1/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int maxProduct(String[] words) {
        final int n = words.length;
        int[] bits = new int[n];
        for (int i = 0; i < n; i++) {
            for (char c : words[i].toCharArray()) {
                bits[i] |= 1 << (c - 'a');
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((bits[i] & bits[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}

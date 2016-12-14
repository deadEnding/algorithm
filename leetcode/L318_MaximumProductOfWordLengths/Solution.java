package leetcode.L318_MaximumProductOfWordLengths;

/**
 * @author: deadend
 * @date: 11:19 AM 12/14/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int maxProduct(String[] words) {
        final int n = words.length;
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            for (char c : words[i].toCharArray()) {
                b[i] |= 1 << (c - 'a');
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((b[i] & b[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}

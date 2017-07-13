package leetcode.again.L345_ReverseVowelsOfAString;

/**
 * @author: deadend
 * @date: 2:44 PM 3/11/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public String reverseVowels(String s) {
        final int n = s.length();
        char[] chs = s.toCharArray();
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            while (i < j && !isVowel(chs[i])) {
                i++;
            }

            while (i < j && !isVowel(chs[j])) {
                j--;
            }

            if (i < j) {
                char t = chs[i];
                chs[i] = chs[j];
                chs[j] = t;
            }
        }
        return new String(chs);
    }
}

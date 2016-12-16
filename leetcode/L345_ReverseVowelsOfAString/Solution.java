package leetcode.L345_ReverseVowelsOfAString;

/**
 * @author: deadend
 * @date: 5:04 PM 12/16/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    private boolean isVowel(char ch) {
        char c = Character.toLowerCase(ch);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        for (int i = 0, j = ch.length - 1; i < j; i++, j--) {
            while (i < j && !isVowel(ch[i])) {
                i++;
            }

            while (i < j && !isVowel(ch[j])) {
                j--;
            }

            char c = ch[i];
            ch[i] = ch[j];
            ch[j] = c;
        }
        return new String(ch);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseVowels("leetcode"));
    }
}

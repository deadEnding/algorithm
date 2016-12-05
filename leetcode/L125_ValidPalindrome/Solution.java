package leetcode.L125_ValidPalindrome;

/**
 * @author: deadend
 * @date: 1:46 PM 12/5/16
 * @version: 1.0
 * @description:
 */

public class Solution {
    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (i < j && !Character.isAlphabetic(s.charAt(i)) && !Character.isDigit(s.charAt(i))) {
                i++;
            }

            while (i < j && !Character.isAlphabetic(s.charAt(j)) && !Character.isDigit(s.charAt(j))) {
                j--;
            }

            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
        }
        return true;
    }
}
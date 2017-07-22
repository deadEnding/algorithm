package leetcode.L125_ValidPalindrome;


public class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < r && !Character.isDigit(s.charAt(l)) && !Character.isLetter(s.charAt(l))) {
                l++;
            }

            while (l < r && !Character.isDigit(s.charAt(r)) && !Character.isLetter(s.charAt(r))) {
                r--;
            }

            if (Character.toLowerCase(s.charAt(l++)) != Character.toLowerCase(s.charAt(r--))) {
                return false;
            }
        }

        return true;
    }
}

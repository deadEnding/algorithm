package leetcode.L408_ValidWordAbbreviation;

import java.util.Arrays;

/**
 * @author: deadend
 * @date: 5:34 PM 3/13/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            char c = abbr.charAt(j);
            if (word.charAt(i) == c) {
                i++;
                j++;
            } else if (Character.isLetter(c)) {
                return false;
            } else {
                if (c == '0') {
                    return false;
                }
                int n = 0;
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    n = n * 10 + abbr.charAt(j) - '0';
                    j++;
                }
                i += n;
            }
        }
        return i == word.length() && j == abbr.length();
    }

    public static void main(String[] args) {
    }
}

package leetcode.L520_DetectCapital;

/**
 * @author: deadend
 * @date: 4:48 PM 2/20/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.toUpperCase().equals(word) || word.toLowerCase().equals(word)) {
            return true;
        }

        if (word.length() > 1 && Character.isUpperCase(word.charAt(0))) {
            String s = word.substring(1);
            return s.toLowerCase().equals(s);
        }

        return false;
    }
}

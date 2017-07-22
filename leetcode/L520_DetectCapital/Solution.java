package leetcode.again.L520_DetectCapital;

/**
 * @author: deadend
 * @date: 10:30 PM 28/03/2017
 */


public class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.toLowerCase().equals(word) || word.toUpperCase().equals(word)) {
            return true;
        }

        String t = word.substring(1);
        return Character.isUpperCase(word.charAt(0)) && t.toLowerCase().equals(t);
    }
}

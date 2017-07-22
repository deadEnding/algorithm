package leetcode.L524_LongestWordInDictionaryThroughDeleting;

import java.util.List;

/**
 * @author: deadend
 * @date: 10:43 AM 29/03/2017
 */


public class Solution {
    private boolean match(String s, String t) {
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(j)) {
                if (++j == t.length()) {
                    return true;
                }
            }
        }
        return false;
    }

    public String findLongestWord(String s, List<String> d) {
        String result = "";
        for (String t : d) {
            if (match(s, t)) {
                if (t.length() > result.length()) {
                    result = t;
                } else if (t.length() == result.length()) {
                    result = result.compareTo(t) < 0 ? result : t;
                }
            }
        }
        return result;
    }
}

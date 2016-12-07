package leetcode.L151_ReverseWordsInAString;

/**
 * @author: deadend
 * @date: 3:24 PM 12/7/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");
        StringBuffer sb = new StringBuffer();
        for (String w : words) {
            if (sb.length() != 0) {
                sb.insert(0, " ");
            }
            sb.insert(0, w);
        }
        return sb.toString();
    }
}

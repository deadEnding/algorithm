package leetcode.L344_ReverseString;

/**
 * @author: deadend
 * @date: 5:02 PM 12/16/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public String reverseString(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}

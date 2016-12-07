package leetcode.L171_ExcelSheetColumnNumber;

/**
 * @author: deadend
 * @date: 9:08 PM 12/7/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int titleToNumber(String s) {
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            n = (s.charAt(i) - 'A' + 1) + 26 * n;
        }
        return n;
    }
}

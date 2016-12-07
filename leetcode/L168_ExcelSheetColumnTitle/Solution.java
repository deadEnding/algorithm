package leetcode.L168_ExcelSheetColumnTitle;

/**
 * @author: deadend
 * @date: 9:00 PM 12/7/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public String convertToTitle(int n) {
        StringBuffer sb = new StringBuffer();
        while (n > 0) {
            sb.append((char) ((n - 1) % 26 + 'A'));
            n = (n - 1) / 26;
        }
        return sb.reverse().toString();
    }
}

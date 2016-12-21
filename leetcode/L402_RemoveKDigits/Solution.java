package leetcode.L402_RemoveKDigits;

/**
 * @author: deadend
 * @date: 11:42 AM 12/21/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public String removeKdigits(String num, int k) {
        final int m = num.length() - k;

        StringBuffer sb = new StringBuffer();
        for (int i = 0, start = 0; i < m; i++) {
            int end = start + 1;
            int minIndex = start;
            while (num.length() - end + i >= m) {
                minIndex = num.charAt(minIndex) > num.charAt(end) ? end : minIndex;
                end++;
            }
            if (!(sb.length() == 0 && num.charAt(minIndex) == '0')) {
                sb.append(num.charAt(minIndex));
            }
            start = minIndex + 1;
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}

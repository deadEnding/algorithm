package leetcode.again.L006_ZigzagConversion;

/**
 * @author: deadend
 * @date: 7:P10 PM 3/2/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public String convert(String s, int numRows) {
        final int n = s.length();
        if (n <= 1 || numRows == 1) {
            return s;
        }

        StringBuffer buffer = new StringBuffer();
        int dist = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            int d = dist - 2 * i;
            for (int j = i; j < n; j += dist) {
                buffer.append(s.charAt(j));
                if (d != 0 && d != dist && j + d < n)
                    buffer.append(s.charAt(j + d));
            }
        }
        return buffer.toString();
    }
}

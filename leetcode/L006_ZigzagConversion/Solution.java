package leetcode.L006_ZigzagConversion;

/**
 * @author: deadend
 * @date: 11:07 AM 11/27/16
 * @version: 1.0
 * @description: 确定周期
 */


public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        final int n = s.length();
        final int CIRCLE = 2 * (numRows - 1);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < n; j += CIRCLE) {
                sb.append(s.charAt(j));
                if (i != 0 && i != numRows - 1) {
                    int k = j + CIRCLE - 2 * i;
                    if (k < n) {
                        sb.append(s.charAt(k));
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        String s = "PAYPALISHIRING";
//        String t = "PAHNAPLSIIGYIR";
        System.out.println(new Solution().convert("L476_NumberComplement", 2));
    }
}

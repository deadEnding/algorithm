package leetcode.L415_AddStrings;

/**
 * @author: deadend
 * @date: 7:12 PM 12/21/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public String addStrings(String num1, String num2) {
        final int n1 = num1.length();
        final int n2 = num2.length();
        StringBuffer sum = new StringBuffer();
        int c = 0;
        for (int i = 0; i < n1 || i < n2; i++) {
            int d1 = i < n1 ? num1.charAt(n1 - 1 - i) - '0' : 0;
            int d2 = i < n2 ? num2.charAt(n2 - 1 - i) - '0' : 0;
            sum.insert(0, (d1 + d2 + c) % 10);
            c = (d1 + d2 + c) / 10;
        }
        if (c != 0) {
            sum.insert(0, c);
        }
        return sum.toString();
    }

    public static void main(String[] args) {
        String num1 = "99";
        String num2 = "9";
        System.out.println(new Solution().addStrings(num1, num2));
    }
}

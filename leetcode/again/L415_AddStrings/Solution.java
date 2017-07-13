package leetcode.again.L415_AddStrings;

/**
 * @author: deadend
 * @date: 7:43 PM 3/17/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public String addStrings(String num1, String num2) {
        final int n1 = num1.length(), n2 = num2.length();
        StringBuilder builder = new StringBuilder();

        int c = 0;
        for (int i = n1 - 1, j = n2 - 1; i >= 0 || j >= 0; i--, j--) {
            int a1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int a2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = a1 + a2 + c;
            c = sum / 10;
            builder.insert(0, sum % 10);
        }

        if (c != 0) {
            builder.insert(0, c);
        }

        return builder.toString();
    }
}

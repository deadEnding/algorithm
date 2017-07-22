package leetcode.again.L043_MultiplyStrings;

/**
 * @author: deadend
 * @date: 9:50 AM 3/4/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    private StringBuilder multiply0(String num1, int digit) {
        StringBuilder builder = new StringBuilder();
        if (digit == 0 || num1.equals("0")) {
            return builder.append(0);
        }
        int c = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int m = digit * (num1.charAt(i) - '0') + c;
            builder.append(m % 10);
            c = m / 10;
        }
        if (c != 0) {
            builder.append(c);
        }
        return builder;
    }

    private StringBuilder add(StringBuilder num1, StringBuilder num2) {
        int c = 0;
        StringBuilder sum = new StringBuilder();
        for (int i = 0; i < num1.length() || i < num2.length(); i++) {
            int d1 = i < num1.length() ? (num1.charAt(i) - '0') : 0;
            int d2 = i < num2.length() ? (num2.charAt(i) - '0') : 0;
            int s = d1 + d2 + c;
            sum.append(s % 10);
            c = s / 10;
        }
        if (c != 0) {
            sum.append(c);
        }
        return sum;
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        final int n1 = num1.length();
        StringBuilder sum = new StringBuilder();

        for (int i = n1 - 1; i >= 0; i--) {
            StringBuilder m = multiply0(num2, num1.charAt(i) - '0');
            for (int k = 0; k < n1 - 1 - i; k++) {
                m.insert(0, 0);
            }
            sum = add(sum, m);
        }
        return sum.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().multiply("1", "123321"));
    }
}

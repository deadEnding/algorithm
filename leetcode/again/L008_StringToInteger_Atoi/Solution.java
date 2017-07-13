package leetcode.again.L008_StringToInteger_Atoi;


public class Solution {
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }

        str = str.trim();
        if (str.equals("")) {
            return 0;
        }

        int sign = 1;
        int index = 0;
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        long num = 0L;
        for (; index < str.length(); index++) {
            char c = str.charAt(index);
            if (!Character.isDigit(c)) {
                break;
            }

            num = num * 10 + c - '0';
            if (num > Integer.MAX_VALUE) {
                break;
            }
        }

        if (sign * num > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (sign * num < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) (sign * num);
    }
}

package leetcode.L504_Base7;

/**
 * @author: deadend
 * @date: 4:42 PM 28/03/2017
 */


public class Solution {
    public String convertToBase7(int num) {
        boolean sign = num >= 0;
        StringBuilder builder = new StringBuilder();
        num = Math.abs(num);
        do {
            builder.append(num % 7);
            num /= 7;
        } while (num != 0);

        builder.append(sign ? "" : "-");
        return builder.reverse().toString();
    }
}

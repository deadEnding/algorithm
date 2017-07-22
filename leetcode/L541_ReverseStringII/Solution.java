package leetcode.L541_ReverseStringII;

/**
 * @author: deadend
 * @date: 10:02 PM 01/04/2017
 */


public class Solution {
    public String reverseStr(String s, int k) {
        final int n = s.length();
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= (int)Math.ceil((double)n / k); i++) {
            String t = s.substring((i - 1) * k, Math.min(i * k, n));
            if (i % 2 == 1) {
                builder.append(new StringBuilder(t).reverse().toString());
            } else {
                builder.append(t);
            }
        }
        return builder.toString();
    }
}

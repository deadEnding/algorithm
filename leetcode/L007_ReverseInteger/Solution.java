package leetcode.L007_ReverseInteger;

/**
 * @author: deadend
 * @date: 11:38 AM 11/27/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        long xcp = Math.abs((long) x);
        long rev = 0L;

        while (xcp != 0L) {
            rev = rev * 10 + xcp % 10;
            xcp = xcp / 10;
        }

        if (sign == -1 && -rev < Integer.MIN_VALUE) {
            return 0;
        }

        if (sign == 1 && rev > Integer.MAX_VALUE) {
            return 0;
        }
        return sign * (int) rev;
    }

    public static void main(String[] args) {
        int x = -12345;
        System.out.println(new Solution().reverse(x));

        int   i = -Integer.MIN_VALUE;
        long  l = -Long.MIN_VALUE;
        System.out.println(i);
        System.out.println(l);
    }
}
package leetcode.L029_DivideTwoIntegers;

/**
 * @author: deadend
 * @date: P10:37 AM 11/30/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        long dd = Math.abs((long) dividend);
        long dr = Math.abs((long) divisor);

        long result = 0L;
        while (dd >= dr) {
            long ndr = dr;
            for (int i = 0; dd >= ndr; i++, ndr <<= 1) {
                dd -= ndr;
                result += 1 << i;
            }
        }

        return (int) (((dividend ^ divisor) >>> 31) == 1 ? -result : result);
    }

    public static void main(String[] args) {
        int a = 1 << 30;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(a);
        System.out.println(Integer.toBinaryString(a << 1));
        System.out.println(a << 1);
        System.out.println(new Solution().divide(-1, 1));
    }
}
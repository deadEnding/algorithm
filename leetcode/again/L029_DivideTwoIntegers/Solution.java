package leetcode.again.L029_DivideTwoIntegers;

/**
 * @author: deadend
 * @date: 9:28 AM 3/3/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        long dd = Math.abs((long) dividend);
        long dr = Math.abs((long) divisor);

        long result = 0L;
        while (dd >= dr) {
            long ndr = dr;
            for (int i = 1; ndr <= dd; i <<= 1, ndr <<= 1) {
                dd -= ndr;
                result += i;
            }
        }

        return (int) (((dividend ^ divisor) >>> 31) == 0 ? result : -result);
    }
}


class BasicSolution {

    private int div(long dd, long dr) {
        if (dd < dr) {
            return 0;
        }
        long tmp = dr;
        int i = 1;
        while (tmp + tmp <= dd) {
            tmp += tmp;
            i <<= 1;
        }
        return i + div(dd - tmp, dr);
    }

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean sign = ((dividend ^ divisor) >>> 31) == 0;
        return (sign ? 1 : -1) * div(Math.abs((long) dividend), Math.abs((long) divisor));
    }

    public static void main(String[] args) {
        int dd = 1;
        int dr = -1;
        System.out.println(new Solution().divide(dd, dr));
    }
}

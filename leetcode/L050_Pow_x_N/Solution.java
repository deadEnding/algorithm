package leetcode.L050_Pow_x_N;

/**
 * @author: deadend
 * @date: 9:18 PM 11/30/16
 * @version: 1.0
 * @description:
 */

public class Solution {
    public double myPow(double x, int n) {
        double pow = 1;

        double base = x;
        long m = Math.abs((long) n);
        while (m > 0) {
            if (m % 2 == 1) {
                pow *= base;
            }

            base *= base;
            m >>= 1;
        }

        return n < 0 ? 1.0 / pow : pow;
    }
}


class OldSolution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        int sign = n >= 0 ? 1 : -1;
        double half = myPow(x, n / 2 * sign);
        double mid = half * half * (n % 2 * sign == 1 ? x : 1);
        return n >= 0 ? mid : 1 / mid;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myPow(2.00000, Integer.MIN_VALUE));
    }
}

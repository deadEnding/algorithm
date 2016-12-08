package leetcode.L201_BitwiseAndOfNumbersRange;

/**
 * @author: deadend
 * @date: 3:58 PM 12/8/16
 * @version: 1.0
 * @description:
 */

public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int offset = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            offset++;
        }
        return m << offset;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rangeBitwiseAnd(Integer.MAX_VALUE - 1, Integer.MAX_VALUE));
    }
}

class BasicSolution {
    public int rangeBitwiseAnd(int m, int n) {
        final int delta = n - m;
        int and = 0;
        for (long i = 1; m >= i; i *= 2) {
            if ((m & i) != 0 && (m % i + delta < i)) {
                and |= i;
            }
        }
        return and;
    }
}

package leetcode.L400_NthDigit;

/**
 * @author: deadend
 * @date: 9:47 AM 12/21/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int findNthDigit(int n) {
        long i = 1, f = 9, start = 1;
        while (n > i * f) {
            n -= (i++) * f;
            f *= 10;
            start *= 10;
        }

        String k = String.valueOf(start + (n - 1) / i);
        return k.charAt((int)((n - 1) % i)) - '0';
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findNthDigit(11));
    }
}

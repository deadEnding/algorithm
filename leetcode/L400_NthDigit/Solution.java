package leetcode.L400_NthDigit;

/**
 * @author: deadend
 * @date: P10:02 AM 3/16/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int findNthDigit(int n) {
        int ix = 1;
        long base = 1;
        while (n > ix * 9L * base) {
            n -= ix * 9L * base;
            ix++;
            base *= 10L;
        }

        return String.valueOf((n - 1) / ix + base).charAt((n - 1) % ix) - '0';
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findNthDigit(Integer.MAX_VALUE));
    }
}

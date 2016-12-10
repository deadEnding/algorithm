package leetcode.L233_NumberOfDigitOne;

/**
 * @author: deadend
 * @date: 4:34 PM 12/10/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int countDigitOne(int n) {
        int count = 0;
        for (long base = 1; base <= n; base *= 10) {   // 统计每一位为1的数的个数
            long x = n / base;
            long y = n % base;
            count += (x + 8) / 10 * base + (x % 10 == 1 ? y + 1: 0);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countDigitOne(100));
    }
}

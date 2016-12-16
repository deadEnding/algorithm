package leetcode.L357_CountNumbersWithUniqueDigits;

/**
 * @author: deadend
 * @date: 5:13 PM 12/16/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int count = 1;
        for (int i = 1, base = 1; i <= Math.min(n, 10); base *= (10 - i), i++) {
            count += 9 * base;
        }
        return count;
    }
}

package leetcode.L172_FactorialTrailingZeroes;

/**
 * @author: deadend
 * @date: 9:12 PM 12/7/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int trailingZeroes(int n) {
        int num = 0;
        while (n > 0) {
            num += n / 5;
            n /= 5;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().trailingZeroes(21));
    }
}

package leetcode.L066_PlusOne;

/**
 * @author: deadend
 * @date: 9:33 PM 11/17/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int[] plusOne(int[] digits) {
        final int n = digits.length;

        int c = 1;
        for (int i = n - 1; i >= 0; i--) {
            digits[i] += c;
            c = digits[i] >= 10 ? 1 : 0;
            digits[i] %= 10;
        }
        if (c == 0) {
            return digits;
        }
        int[] result = new int[n + 1];
        result[0] = 1;
        for (int i = 1; i <= n; i++) {
            result[i] = digits[i - 1];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] digits = {};
        int[] result = new Solution().plusOne(digits);
        for (int i : result) {
            System.out.println(i);
        }
    }
}

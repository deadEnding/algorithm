package leetcode.again.L066_PlusOne;

/**
 * @author: deadend
 * @date: 11:04 PM 3/9/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int[] plusOne(int[] digits) {
        int c = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += c;
            c = digits[i] / 10;
            digits[i] %= 10;
        }

        if (c == 0) {
            return digits;
        }

        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = c;
        System.arraycopy(digits, 0, newDigits, 1, digits.length);
        return newDigits;
    }
}

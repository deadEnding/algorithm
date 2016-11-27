package leetcode.L009_PalindromeNumber;

/**
 * @author: deadend
 * @date: 1:21 PM 11/27/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    private int length(int x) {
        int len = 0;
        while (x != 0) {
            len++;
            x /= 10;
        }
        return len;
    }

    private int digit(long x, int i) {
        long base = 1L;
        for (int k = 0; k < i; k++) {
            base *= 10;
        }
        return (int) (x % base / (base / 10));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int len = length(x);
        for (int i = 1, j = len; i < j; i++, j--) {
            if (digit(x, i) != digit(x, j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int x = 1000000001;
        System.out.println(new Solution().isPalindrome(x));
    }
}

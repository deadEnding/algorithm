package leetcode.L367_ValidPerfectSquare;

/**
 * @author: deadend
 * @date: 8:33 PM 12/16/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public boolean isPerfectSquare(int num) {
        long l = 0, r = num;
        while (l <= r) {
            long m = l + (r - l) / 2;
            if (m * m == num) {
                return true;
            } else if (m * m > num) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }
}

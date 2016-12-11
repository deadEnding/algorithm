package leetcode.L263_UglyNumber;

/**
 * @author: deadend
 * @date: 4:09 PM 12/11/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }

        int[] factors = {2, 3, 5};
        for (int f : factors) {
            while (num % f == 0) {
                num /= f;
            }
        }
        return num == 1;
    }
}

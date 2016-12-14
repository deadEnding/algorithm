package leetcode.L342_PowerOfFour;

/**
 * @author: deadend
 * @date: 11:10 PM 12/14/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public boolean isPowerOfFour(int num) {
        while (num > 0 && num % 4 == 0) {
            num >>= 2;
        }
        return num == 1;
    }
}

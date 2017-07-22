package leetcode.L231_PowerOfTwo;

/**
 * @author: deadend
 * @date: 7:09 PM 2/28/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}

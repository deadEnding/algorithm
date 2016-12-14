package leetcode.L326_PowerOfThree;

/**
 * @author: deadend
 * @date: 10:53 PM 12/14/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public boolean isPowerOfThree(int n) {
        while (n > 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}

class MathSolution {
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}

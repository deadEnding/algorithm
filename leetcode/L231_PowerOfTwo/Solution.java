package leetcode.L231_PowerOfTwo;

/**
 * @author: deadend
 * @date: 4:07 PM 12/10/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}

class OtherSolution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += (n >> i) & 1;
        }
        return count == 1;
    }
}

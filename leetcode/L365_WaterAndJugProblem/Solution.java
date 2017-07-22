package leetcode.L365_WaterAndJugProblem;

/**
 * @author: deadend
 * @date: 1:05 PM 3/1/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    private int gcd(int x, int y) {
        return x % y == 0 ? y : gcd(y, x % y);
    }

    public boolean canMeasureWater(int x, int y, int z) {
        return z == 0 || z == x + y || (0 < z && z < x + y && z % gcd(x, y) == 0);
    }
}

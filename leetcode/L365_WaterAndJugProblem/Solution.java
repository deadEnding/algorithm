package leetcode.L365_WaterAndJugProblem;

/**
 * @author: deadend
 * @date: 5:38 PM 12/16/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    private int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }

    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0)
            return true;
        return x + y < z ? false : z % gcd(x, y) == 0;
    }
}

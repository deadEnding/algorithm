package leetcode.L319_BulbSwitcher;

/**
 * @author: deadend
 * @date: 8:26 PM 12/14/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int bulbSwitch(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            count++;
        }
        return count;
    }
}

class MathSolution {
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}

package leetcode.L134_GasStation;

/**
 * @author: deadend
 * @date: 12:15 PM 12/6/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int ix = 0;
        for (int i = 0, subsum = 0; i < gas.length; i++) {
            int delta = gas[i] - cost[i];
            sum += delta;
            subsum += delta;

            if (subsum < 0) {
                ix = i + 1;
                subsum = 0;
            }
        }
        return sum >= 0 ? ix : -1;
    }
}

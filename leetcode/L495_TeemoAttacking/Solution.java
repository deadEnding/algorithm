package leetcode.L495_TeemoAttacking;

/**
 * @author: deadend
 * @date: 11:27 AM 2/5/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) {
            return 0;
        }

        int total = duration;
        for (int i = 1; i < timeSeries.length; i++) {
            total += Math.min(duration, timeSeries[i] - timeSeries[i - 1]);
        }
        return total;
    }
}

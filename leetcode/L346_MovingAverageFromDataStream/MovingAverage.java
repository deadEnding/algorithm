package leetcode.L346_MovingAverageFromDataStream;

/**
 * @author: deadend
 * @date: 9:54 PM 3/9/17
 * @version: 1.0
 * @description:
 */


public class MovingAverage {

    int ix;
    long sum;
    int[] cache;
    boolean full;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        cache = new int[size];
    }

    public double next(int val) {
        if (ix > 3) {
            ix %= cache.length;
            full = true;
        }
        sum += val - cache[ix];
        cache[ix++] = val;
        return (double)sum / (full ? cache.length : ix);
    }
}

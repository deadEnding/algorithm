package leetcode.L346_MovingAverageFromDataStream;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: deadend
 * @date: 9:54 PM 3/9/17
 * @version: 1.0
 * @description:
 */


class MovingAverage {

    private Queue<Integer> queue = new LinkedList<>();
    private long sum;
    private int size;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        if (queue.size() == size) {
            sum -= queue.poll();
        }

        queue.offer(val);
        sum += val;
        return ((double) sum) / queue.size();
    }
}


class OldMovingAverage {

    int ix;
    long sum;
    int[] cache;
    boolean full;

    /** Initialize your data structure here. */
    public OldMovingAverage(int size) {
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

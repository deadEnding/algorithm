package leetcode.again.L295_FindMedianFromDataStream;

import java.util.PriorityQueue;

/**
 * @author: deadend
 * @date: 4:56 PM 3/14/17
 * @version: 1.0
 * @description:
 */


public class MedianFinder {

    private PriorityQueue<Integer> smallNums;
    private PriorityQueue<Integer> largeNums;

    /** initialize your data structure here. */
    public MedianFinder() {
        smallNums = new PriorityQueue<>((i1, i2) -> (i2 - i1));
        largeNums = new PriorityQueue<>();
    }

    public void addNum(int num) {
        smallNums.offer(num);
        largeNums.offer(smallNums.poll());
        if (smallNums.size() < largeNums.size()) {
            smallNums.offer(largeNums.poll());
        }
    }

    public double findMedian() {
        return smallNums.size() > largeNums.size() ? smallNums.peek() : ((smallNums.peek() + largeNums.peek()) / 2.0);
    }
}

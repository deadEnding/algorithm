package leetcode.L295_FindMedianFromDataStream;

import java.util.PriorityQueue;

/**
 * @author: deadend
 * @date: 4:56 PM 3/14/17
 * @version: 1.0
 * @description:
 */

class MedianFinder {

    private PriorityQueue<Integer> leftHalfHeap;
    private PriorityQueue<Integer> rightHalfHeap;

    public MedianFinder() {
        leftHalfHeap = new PriorityQueue<>((i1, i2) -> (i2 - i1));
        rightHalfHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        leftHalfHeap.offer(num);
        rightHalfHeap.offer(leftHalfHeap.poll());
        if (leftHalfHeap.size() < rightHalfHeap.size()) {
            leftHalfHeap.offer(rightHalfHeap.poll());
        }
    }

    public double findMedian() {
        if (leftHalfHeap.size() == rightHalfHeap.size()) {
            return (leftHalfHeap.peek() + rightHalfHeap.peek()) / 2.0;
        } else {
            return leftHalfHeap.peek();
        }
    }
}


class OldMedianFinder {

    private PriorityQueue<Integer> smallNums;
    private PriorityQueue<Integer> largeNums;

    /** initialize your data structure here. */
    public OldMedianFinder() {
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

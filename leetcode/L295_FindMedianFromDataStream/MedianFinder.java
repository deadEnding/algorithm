package leetcode.L295_FindMedianFromDataStream;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author: deadend
 * @date: P10:19 AM 12/12/16
 * @version: 1.0
 * @description:
 */


public class MedianFinder {
    private PriorityQueue<Integer> smallMinHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> largeMinHeap = new PriorityQueue<>();

    // Adds A number into the data structure.
    public void addNum(int num) {
        largeMinHeap.add(num);
        smallMinHeap.add(-largeMinHeap.poll());
        if (largeMinHeap.size() < smallMinHeap.size()) {
            largeMinHeap.add(-smallMinHeap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        return largeMinHeap.size() > smallMinHeap.size() ? largeMinHeap.peek() : (largeMinHeap.peek() - smallMinHeap.peek()) / 2.0;
    }
}

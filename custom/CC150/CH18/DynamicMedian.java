package custom.CC150.CH18;

import java.util.PriorityQueue;

/**
 * @author: deadend
 * @date: 8:55 PM 1/5/17
 * @version: 1.0
 * @description:
 */


public class DynamicMedian {

    private PriorityQueue<Integer> smallMinHeap;
    private PriorityQueue<Integer> largeMinHeap;

    public DynamicMedian() {
        smallMinHeap = new PriorityQueue<>();
        largeMinHeap = new PriorityQueue<>();
    }

    public void add(int num) {
        smallMinHeap.offer(-num);
        largeMinHeap.offer(-smallMinHeap.poll());
        if (largeMinHeap.size() > smallMinHeap.size()) {
            smallMinHeap.offer(-largeMinHeap.poll());
        }
    }

    public double findMedian() {
        if (smallMinHeap.size() > largeMinHeap.size()) {
            return -smallMinHeap.peek();
        } else {
            return (largeMinHeap.peek() - smallMinHeap.peek()) / 2.0;
        }
    }
}

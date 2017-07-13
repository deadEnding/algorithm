package leetcode.L480_SlidingWindowMedian;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: deadend
 * @date: 6:49 PM 2/4/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    PriorityQueue<Double> smallHeap = new PriorityQueue<>(new Comparator<Double>() {
        @Override
        public int compare(Double o1, Double o2) {
            return Double.compare(o2, o1);
        }
    });
    PriorityQueue<Double> largeHeap = new PriorityQueue<>();

    public void add(double n) {
        smallHeap.offer(n);
        largeHeap.offer(smallHeap.poll());
        if (smallHeap.size() < largeHeap.size()) {
            smallHeap.offer(largeHeap.poll());
        }
    }

    public void remove(double n) {
        if (!smallHeap.remove(n)) {
            largeHeap.remove(n);
        }
        if (smallHeap.size() < largeHeap.size()) {
            smallHeap.offer(largeHeap.poll());
        }
    }

    public double findMedian() {
        if (smallHeap.size() == largeHeap.size()) {
            return (smallHeap.peek() + largeHeap.peek()) / 2;
        }
        return smallHeap.peek();
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        for (int i = 0; i < k - 1; i++) {
            add(nums[i]);
        }

        for (int i = k - 1, j = 0; i < nums.length; i++) {
            add(nums[i]);
            result[j++] = findMedian();
            remove(nums[i - k + 1]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        double[] result = new Solution().medianSlidingWindow(nums, 3);
        for (double d : result) {
            System.out.print(d + ", ");
        }
    }
}

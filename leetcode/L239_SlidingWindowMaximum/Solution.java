package leetcode.L239_SlidingWindowMaximum;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 8:54 PM 3/16/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        final int n = nums.length;
        if (n == 0) {
            return new int[0];
        }

        Deque<Integer> deque = new LinkedList<>();
        int[] maxs = new int[n - k + 1];
        for (int i = 0, ix = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.getFirst() == i - k) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
                deque.removeLast();
            }

            deque.addLast(i);
            if (i >= k - 1) {
                maxs[ix++] = nums[deque.getFirst()];
            }
        }
        return maxs;
    }
}

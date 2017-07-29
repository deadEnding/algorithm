package leetcode.L084_LargestRectangleInHistogram;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 4:54 PM 3/15/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int largestRectangleArea(int[] heights) {
        final int n = heights.length;

        int max = 0;
        LinkedList<int[]> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] h = stack.pop();
                max = Math.max(max, (stack.isEmpty() ? i : (i - 1 - stack.peek()[0])) * h[1]);
            }
            stack.push(new int[] {i, heights[i]});
        }

        while (!stack.isEmpty()) {
            int[] h = stack.pop();
            max = Math.max(max, (stack.isEmpty() ? n : (n - 1 - stack.peek()[0])) * h[1]);
        }

        return max;
    }
}

class OldSolution {
    public int largestRectangleArea(int[] heights) {
        final int n = heights.length;
        LinkedList<Integer> stack = new LinkedList<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int ix = stack.pop();
                max = Math.max(max, heights[ix] * (i - 1 - (stack.isEmpty() ? -1 : stack.peek())));
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int ix = stack.pop();
            max = Math.max(max, heights[ix] * (n - 1 - (stack.isEmpty() ? -1 : stack.peek())));
        }

        return max;
    }
}

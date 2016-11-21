package leetcode.L084_LargestRectangleInHistogram;

/**
 * @author: deadend
 * @date: 9:40 PM 11/20/16
 * @version: 1.0
 * @description:
 */


public class Solution {

    private int getMax(int[] heights, int s, int e) {
        if (s == e) {
            return 0;
        }

        if (s + 1 == e) {
            return heights[s];
        }

        int min = s;
        boolean sorted = true;
        for (int i = s; i < e; i++) {
            if (i != s && heights[i - 1] > heights[i]) {
                sorted = false;
            }
            min = heights[min] > heights[i] ? i : min;
        }

        if (sorted) {
            int max = 0;
            for (int i = s; i < e; i++) {
                max = Math.max(max, heights[i] * (e - i));
            }
            return max;
        }

        int leftMax = getMax(heights, s, min);
        int rightMax = getMax(heights, min + 1, e);
        return Math.max(Math.max(leftMax, rightMax), heights[min] * (e - s));
    }

    public int largestRectangleArea(int[] heights) {
        return getMax(heights, 0, heights.length);
    }

    public static void main(String[] args) {
        int[] heights = {2,4};
        System.out.println(new Solution().largestRectangleArea(heights));
    }
}

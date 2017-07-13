package leetcode.L085_MaximalRectangle;

/**
 * @author: deadend
 * @date: P10:00 PM 11/21/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    private int getMax(int[] heights, int s, int e) {
        if (s == e) {
            return 0;
        }

        if (s + 1 ==  e) {
            return heights[s];
        }

        boolean sorted = true;
        int min = s;
        for (int i = s; i < e; i++) {
            if (i > s && heights[i] < heights[i - 1]) {
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

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        final int m = matrix.length;
        final int n = matrix[0].length;
        int[] heights = new int[n];

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                heights[j] = matrix[i][j] == '0' ? 0 : heights[j] + 1;
            }
            max = Math.max(max, getMax(heights, 0, n));
        }
        return max;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'0', '1'}, {'1', '0'}};
        System.out.println(new Solution().maximalRectangle(matrix));
    }
}

package leetcode.L329_LongestIncreasingPathInAMatrix;

/**
 * @author: deadend
 * @date: 1:00 PM 3/3/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    private int getMax(int d1, int d2, int d3, int d4) {
        return Math.max(Math.max(d1, d2), Math.max(d3, d4));
    }

    private int dfs(int i, int j, int[][] matrix, long prev, int[][] cache) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || prev >= matrix[i][j])
            return 0;

        if (cache[i][j] == 0) {
            int d1 = dfs(i - 1, j, matrix, matrix[i][j], cache);
            int d2 = dfs(i + 1, j, matrix, matrix[i][j], cache);
            int d3 = dfs(i, j - 1, matrix, matrix[i][j], cache);
            int d4 = dfs(i, j + 1, matrix, matrix[i][j], cache);
            cache[i][j] = getMax(d1, d2, d3, d4) + 1;
        }
        return cache[i][j];
    }

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        final int m = matrix.length;
        final int n = matrix[0].length;
        int[][] cache = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(i, j, matrix, Integer.MIN_VALUE - 1L, cache));
            }
        }
        return max;
    }
}

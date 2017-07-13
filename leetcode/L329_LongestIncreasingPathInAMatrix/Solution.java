package leetcode.L329_LongestIncreasingPathInAMatrix;

/**
 * @author: deadend
 * @date: 9:35 PM 2/16/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    private int dfs(int[][] matrix, int i, int j, long prev, int[][] cache) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] <= prev) {
            return 0;
        }

        if (cache[i][j] == 0) {
            int l1 = dfs(matrix, i + 1, j, matrix[i][j], cache);
            int l2 = dfs(matrix, i - 1, j, matrix[i][j], cache);
            int l3 = dfs(matrix, i, j + 1, matrix[i][j], cache);
            int l4 = dfs(matrix, i, j - 1, matrix[i][j], cache);
            cache[i][j] = Math.max(Math.max(l1, l2), Math.max(l3, l4)) + 1;
        }
        return cache[i][j];
    }

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        final int m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m][n];
        int longest = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                longest = Math.max(longest, dfs(matrix, i, j, Integer.MIN_VALUE - 1L, cache));
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[][] m = {{3,4,5}, {3,2,6}, {2,2,1}};
        System.out.println(new Solution().longestIncreasingPath(m));
    }
}

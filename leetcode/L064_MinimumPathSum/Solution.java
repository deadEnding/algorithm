package leetcode.L064_MinimumPathSum;

/**
 * @author: deadend
 * @date: 8:58 PM 11/17/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int minPathSum(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        int[] row = new int[n];

        for (int i = 0; i < m; i++) {
            row[0] += grid[i][0];
            for (int j = 1; j < n; j++) {
                row[j] = (i == 0 ? row[j - 1] : Math.min(row[j], row[j - 1])) + grid[i][j];
            }
        }
        return row[n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,0}, {2,2,1}};
        System.out.println(new Solution().minPathSum(grid));
    }
}

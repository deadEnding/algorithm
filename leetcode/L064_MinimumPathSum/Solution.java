package leetcode.L064_MinimumPathSum;

/**
 * @author: deadend
 * @date: 8:58 PM 11/17/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        final int m = grid.length;
        final int n = grid[0].length;

        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = (i == 0 ? dp[j - 1] : Math.min(dp[j - 1], dp[j])) + grid[i][j];
            }
        }

        return dp[n - 1];
    }
}


class OldSolution {
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

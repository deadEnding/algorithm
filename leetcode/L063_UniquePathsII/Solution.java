package leetcode.L063_UniquePathsII;

/**
 * @author: deadend
 * @date: 8:47 PM 11/17/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        final int m = obstacleGrid.length;
        final int n = obstacleGrid[0].length;
        int[] row = new int[n];
        row[0] = 1 - obstacleGrid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    row[j] = 0;
                } else {
                    row[j] += j == 0 ? 0 : row[j - 1];
                }
            }
        }
        return row[n - 1];
    }

    public static void main(String[] args) {
        int[][] og = {{0,0,0}, {0,1,1}, {1,0,0}};
        System.out.println(new Solution().uniquePathsWithObstacles(og));
    }
}

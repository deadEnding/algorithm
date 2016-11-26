package leetcode.L463_IslandPerimeter;

/**
 * @author: deadend
 * @date: 2:25 PM 11/26/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int islandPerimeter(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;

        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result += i - 1 < 0 ? 2 * (0 ^ grid[i][j]) : grid[i-1][j] ^ grid[i][j];
                result += i + 1 >= m ? 2 * (0 ^ grid[i][j]) : grid[i+1][j] ^ grid[i][j];
                result += j - 1 < 0 ? 2 * (0 ^ grid[i][j]) : grid[i][j-1] ^ grid[i][j];
                result += j + 1 >= n ? 2 * (0 ^ grid[i][j]) : grid[i][j+1] ^ grid[i][j];
            }
        }
        return result / 2;
    }

    public static void main(String[] args) {
//        int[][] grid = {{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}};
        int[][] grid = {{1,0}};
        System.out.println(new Solution().islandPerimeter(grid));
    }
}

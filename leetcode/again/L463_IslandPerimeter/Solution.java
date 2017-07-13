package leetcode.again.L463_IslandPerimeter;

/**
 * @author: deadend
 * @date: P10:35 PM 3/16/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int islandPerimeter(int[][] grid) {
        final int m = grid.length, n = grid[0].length;

        int cells = 0;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    cells++;
                    for (int[] d : dirs) {
                        int nx = i + d[0];
                        int ny = j + d[1];
                        if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                            count++;
                        }
                    }
                }
            }
        }
        return 4 * cells - count;
    }
}

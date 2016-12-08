package leetcode.L200_NumberOfIslands;

/**
 * @author: deadend
 * @date: 3:22 PM 12/8/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    private void dfs(char[][] grid, int x, int y, boolean[][] visited) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != '1' || visited[x][y]) {
            return;
        }

        visited[x][y] = true;
        dfs(grid, x - 1, y, visited);
        dfs(grid, x + 1, y, visited);
        dfs(grid, x, y - 1, visited);
        dfs(grid, x, y + 1, visited);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        final int m = grid.length;
        final int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }
}

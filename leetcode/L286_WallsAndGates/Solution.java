package leetcode.L286_WallsAndGates;

/**
 * @author: deadend
 * @date: 2:55 PM 3/11/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    private void dfs(int x, int y, int[][] rooms, boolean[][] visited, int step) {
        if (x < 0 || y < 0 || x >= rooms.length || y >= rooms[0].length || rooms[x][y] == -1
                || (step != 0 && rooms[x][y] == 0) || visited[x][y]) {
            return;
        }

        visited[x][y] = true;
        if (rooms[x][y] > 0) {
            rooms[x][y] = Math.min(rooms[x][y], step);
        }
        dfs(x + 1, y, rooms, visited, step + 1);
        dfs(x - 1, y, rooms, visited, step + 1);
        dfs(x, y + 1, rooms, visited, step + 1);
        dfs(x, y - 1, rooms, visited, step + 1);
        visited[x][y] = false;
    }

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }

        final int m = rooms.length, n = rooms[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    dfs(i, j, rooms, visited, 0);
                }
            }
        }
    }
}

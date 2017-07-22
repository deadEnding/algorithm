package leetcode.L317_ShortestDistanceFromAllBuildings;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: deadend
 * @date: 11:20 AM 3/14/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private boolean reachable(int x, int y, int[][] grid, boolean[][] visited) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] != 2 && !visited[x][y];
    }

    private int distance(int x, int y, int[][] grid, int total) {
        int dist = 0;
        final int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        queue.offer(new int[] {x, y, 0});
        visited[x][y] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int px = p[0], py = p[1];

            if (grid[px][py] == 1) {
                dist += p[2];
                count++;
                continue;
            }

            for (int[] d : directions) {
                int nx = px + d[0], ny = py + d[1];
                if (reachable(nx, ny, grid, visited)) {
                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx, ny, p[2] + 1});
                }
            }
        }

        return count == total ? dist : -1;
    }

    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        final int m = grid.length, n = grid[0].length;
        int total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total += grid[i][j] == 1 ? 1 : 0;
            }
        }

        int min = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int dist = distance(i, j, grid, total);
                    if (dist > 0) {
                        min = min == -1 ? dist : Math.min(min, dist);
                    }
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        System.out.println(new Solution().shortestDistance(grid));
    }
}

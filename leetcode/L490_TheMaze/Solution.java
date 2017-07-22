package leetcode.L490_TheMaze;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: deadend
 * @date: 2:07 PM 3/12/17
 * @version: 1.0
 * @description:
 */

public class Solution {
    private int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private boolean reachable(int x, int y, int[][] maze) {
        return x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0;
    }

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return false;
        }

        final int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            if (p[0] == destination[0] && p[1] == destination[1]) {
                return true;
            }

            for (int i = 0; i < d.length; i++) {
                int nx = p[0], ny = p[1];
                while (reachable(nx + d[i][0], ny + d[i][1], maze)) {
                    nx += d[i][0];
                    ny += d[i][1];
                }

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }

        return false;
    }
}


class DFSSolution {
    private int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private boolean reachable(int x, int y, int[][] maze) {
        return x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0;
    }

    private boolean dfs(int x, int y, int[][] maze, boolean[][] visited, int from, int[] dst) {
        if (visited[x][y]) {
            return false;
        }

        int nx = d[from][0] + x;
        int ny = d[from][1] + y;
        if (!reachable(nx, ny, maze)) {
            if (x == dst[0] && y == dst[1]) {
                return true;
            }

            visited[x][y] = true;
            for (int i = 0; i < d.length; i++) {
                if (i == from) {
                    continue;
                }
                if (reachable(x + d[i][0], y + d[i][1], maze)
                        && dfs(x + d[i][0], y + d[i][1], maze, visited, i, dst)) {
                    return true;
                }
            }
            return false;
        }
        return dfs(nx, ny, maze, visited, from, dst);
    }

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return false;
        }

        final int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < d.length; i++) {
            if (reachable(start[0] + d[i][0], start[1] + d[i][1], maze) &&
                    dfs(start[0] + d[i][0], start[1] + d[i][1], maze, visited, i, destination)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] m = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start = {0, 4};
        int[] dest = {4, 4};
        System.out.println(new Solution().hasPath(m, start, dest));
    }
}

package leetcode.again.L505_TheMazeII;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: deadend
 * @date: 3:52 PM 3/12/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    private int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private boolean reachable(int x, int y, int[][] maze) {
        return x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0;
    }

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return -1;
        }

        final int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < d.length; i++) {
            queue.offer(new int[] {start[0], start[1], i, 0});
        }
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] p = queue.poll();

            int nx = p[0] + d[p[2]][0];
            int ny = p[1] + d[p[2]][1];
            if (reachable(nx, ny, maze)) {
                queue.offer(new int[]{nx, ny, p[2], p[3] + 1});
                continue;
            } else {
                if (!visited[p[0]][p[1]]) {
                    visited[p[0]][p[1]] = true;
                    if (p[0] == destination[0] && p[1] == destination[1]) {
                        return p[3];
                    }

                    for (int i = 0; i < d.length; i++) {
                        int dnx = p[0] + d[i][0], dny = p[1] + d[i][1];
                        if (reachable(dnx, dny, maze)) {
                            queue.offer(new int[] {dnx, dny, i, p[3] + 1});
                        }
                    }
                }
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        int[][] m = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start = {0, 4};
        int[] dest = {3,2};
        System.out.println(new Solution().shortestDistance(m, start, dest));
    }
}

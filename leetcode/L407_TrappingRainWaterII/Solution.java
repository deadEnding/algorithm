package leetcode.L407_TrappingRainWaterII;

import java.util.PriorityQueue;

/**
 * @author: deadend
 * @date: 7:11 PM 3/14/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    class Cell {
        int x, y, h;

        public Cell(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        final int m = heightMap.length, n = heightMap[0].length;
        PriorityQueue<Cell> queue = new PriorityQueue<>((c1, c2) -> (c1.h - c2.h));
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            visited[i][0] = visited[i][n - 1] = true;
            queue.offer(new Cell(i, 0, heightMap[i][0]));
            queue.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
        }

        for (int j = 0; j < n; j++) {
            visited[0][j] = visited[m - 1][j] = true;
            queue.offer(new Cell(0, j, heightMap[0][j]));
            queue.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
        }

        int sum = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            for (int[] d : dirs) {
                int nx = cell.x + d[0];
                int ny = cell.y + d[1];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    sum += heightMap[nx][ny] < cell.h ? cell.h - heightMap[nx][ny] : 0;
                    queue.offer(new Cell(nx, ny, Math.max(heightMap[nx][ny], cell.h)));   // 若邻接位置较低，将其高度替换成cell的高度
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] hm = {{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};
        System.out.println(new Solution().trapRainWater(hm));
    }
}

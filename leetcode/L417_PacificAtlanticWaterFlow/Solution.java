package leetcode.L417_PacificAtlanticWaterFlow;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 8:26 PM 12/21/16
 * @version: 1.0
 * @description:
 */

public class Solution {
    private List<int[]> result = new LinkedList<>();
    private int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private void dfs(int[][] matrix, int[][] visited, int x, int y, int prev, int tag) {
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] < prev || (visited[x][y] & tag) == tag) {
            return;
        }

        visited[x][y] |= tag;
        if (visited[x][y] == 3) {
            result.add(new int[]{x, y});
        }

        for (int i = 0; i < d.length; i++) {
            dfs(matrix, visited, x + d[i][0], y + d[i][1], matrix[x][y], tag);
        }
    }

    public List<int[]> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        final int m = matrix.length;
        final int n = matrix[0].length;
        int[][] visited = new int[m][n];

        for (int i = 0; i < m; i++) {
            dfs(matrix, visited, i, 0, Integer.MIN_VALUE, 1);
            dfs(matrix, visited, i, n - 1, Integer.MIN_VALUE, 2);
        }

        for (int j = 0; j < n; j++) {
            dfs(matrix, visited, 0, j, Integer.MIN_VALUE, 1);
            dfs(matrix, visited, m - 1, j, Integer.MIN_VALUE, 2);
        }
        return result;
    }
}

class BFSSolution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new LinkedList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        final int m = matrix.length;
        final int n = matrix[0].length;
        LinkedList<int[]> queue = new LinkedList<>();
        int[][] visited = new int[m][n];

        for (int i = 0; i < m; i++) {
            queue.offer(new int[]{i, 0});
        }

        for (int j = 0; j < n; j++) {
            queue.offer(new int[]{0, j});
        }

        while (!queue.isEmpty()) {
            int[] p = queue.poll();

            if (p[0] - 1 >= 0 && visited[p[0] - 1][p[1]] == 0  && matrix[p[0] - 1][p[1]] >= matrix[p[0]][p[1]]) {
                queue.offer(new int[]{p[0] - 1, p[1]});
            }

            if (p[0] + 1 < m && visited[p[0] + 1][p[1]] == 0 && matrix[p[0] + 1][p[1]] >= matrix[p[0]][p[1]]) {
                queue.offer(new int[]{p[0] + 1, p[1]});
            }

            if (p[1] - 1 >= 0 && visited[p[0]][p[1] - 1] == 0 && matrix[p[0]][p[1] - 1] >= matrix[p[0]][p[1]]) {
                queue.offer(new int[]{p[0], p[1] - 1});
            }

            if (p[1] + 1 < n && visited[p[0]][p[1] + 1] == 0 && matrix[p[0]][p[1] + 1] >= matrix[p[0]][p[1]]) {
                queue.offer(new int[]{p[0], p[1] + 1});
            }

            visited[p[0]][p[1]] = 1;
        }

        for (int i = 0; i < m; i++) {
            queue.offer(new int[]{i, n - 1});
        }

        for (int j = 0; j < n; j++) {
            queue.offer(new int[]{m - 1, j});
        }

        while (!queue.isEmpty()) {
            int[] p = queue.poll();

            if (visited[p[0]][p[1]] == 1) {
                result.add(p);
            }
            visited[p[0]][p[1]] = 2;

            if (p[0] - 1 >= 0 && visited[p[0] - 1][p[1]] != 2  && matrix[p[0] - 1][p[1]] >= matrix[p[0]][p[1]]) {
                queue.offer(new int[]{p[0] - 1, p[1]});
            }

            if (p[0] + 1 < m && visited[p[0] + 1][p[1]] != 2 && matrix[p[0] + 1][p[1]] >= matrix[p[0]][p[1]]) {
                queue.offer(new int[]{p[0] + 1, p[1]});
            }

            if (p[1] - 1 >= 0 && visited[p[0]][p[1] - 1] != 2 && matrix[p[0]][p[1] - 1] >= matrix[p[0]][p[1]]) {
                queue.offer(new int[]{p[0], p[1] - 1});
            }

            if (p[1] + 1 < n && visited[p[0]][p[1] + 1] != 2 && matrix[p[0]][p[1] + 1] >= matrix[p[0]][p[1]]) {
                queue.offer(new int[]{p[0], p[1] + 1});
            }

        }

        return result;
    }
}

package leetcode.L417_PacificAtlanticWaterFlow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: deadend
 * @date: 1:31 PM 3/11/17
 * @version: 1.0
 * @description:
 */


class Solution {
    private static int PACIFIC = 1;
    private static int ATLANTIC = 2;

    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private List<int[]> result = new ArrayList<>();

    private void dfs(int x, int y, int[][] m, int[][] visited, int tag, int last) {
        if (x < 0 || y < 0 || x >= m.length || y >= m[0].length || (visited[x][y] & tag) != 0 || m[x][y] < last) {
            return;
        }

        visited[x][y] |= tag;
        if (visited[x][y] == (PACIFIC | ATLANTIC)) {
            result.add(new int[] {x, y});
        }

        for (int[] d : dirs) {
            dfs(x + d[0], y + d[1], m, visited, tag, m[x][y]);
        }
    }

    public List<int[]> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        final int m = matrix.length, n = matrix[0].length;
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            dfs(i, 0, matrix, visited, PACIFIC, -1);
            dfs(i, n - 1, matrix, visited, ATLANTIC, -1);
        }

        for (int j = 0; j < n; j++) {
            dfs(0, j, matrix, visited, PACIFIC, -1);
            dfs(m - 1, j, matrix, visited, ATLANTIC, -1);
        }

        return result;
    }
}

class DFSSolution {
    private static final int PACIFIC = 1;
    private static final int ATLANTIC = 2;

    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private void dfs(int x, int y, int[][] m, int mask, int[][] visited, int last, List<int[]> result) {
        if (x < 0 || y < 0 || x >= m.length || y >= m[0].length || m[x][y] < last || (visited[x][y] & mask) != 0) {
            return;
        }

        visited[x][y] |= mask;
        if (visited[x][y] == (PACIFIC | ATLANTIC)) {
            result.add(new int[] {x, y});
        }

        for (int[] d : dirs) {
            dfs(x + d[0], y + d[1], m, mask, visited, m[x][y], result);
        }
    }

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        final int m = matrix.length, n = matrix[0].length;
        int[][] visited = new int[m][n];

        for (int i = 0; i < m; i++) {
            dfs(i, 0, matrix, PACIFIC, visited, -1, result);
            dfs(i, n - 1, matrix, ATLANTIC, visited, -1, result);
        }

        for (int j = 0; j < n; j++) {
            dfs(0, j, matrix, PACIFIC, visited, -1, result);
            dfs(m - 1, j, matrix, ATLANTIC, visited, -1, result);
        }

        return result;
    }
}


class OldSolution {
    private void dfs(int x, int y, int[][] matrix, int[][] visited, int prev, int mask, List<int[]> result) {
        if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length || matrix[x][y] < prev || (visited[x][y] & mask) != 0) {
            return;
        }

        visited[x][y] |= mask;
        if (visited[x][y] == 3) {
            result.add(new int[] {x, y});
        }

        dfs(x + 1, y, matrix, visited, matrix[x][y], mask, result);
        dfs(x - 1, y, matrix, visited, matrix[x][y], mask, result);
        dfs(x, y + 1, matrix, visited, matrix[x][y], mask, result);
        dfs(x, y - 1, matrix, visited, matrix[x][y], mask, result);
    }

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        final int m = matrix.length, n = matrix[0].length;
        int[][] visited = new int[m][n];

        for (int i = 0; i < m; i++) {
            dfs(i, 0, matrix, visited, Integer.MIN_VALUE, 1, result);
            dfs(i, n - 1, matrix, visited, Integer.MIN_VALUE, 2, result);
        }

        for (int j = 0; j < n; j++) {
            dfs(0, j, matrix, visited, Integer.MIN_VALUE, 1, result);
            dfs(m - 1, j, matrix, visited, Integer.MIN_VALUE, 2, result);
        }

        return result;
    }
}

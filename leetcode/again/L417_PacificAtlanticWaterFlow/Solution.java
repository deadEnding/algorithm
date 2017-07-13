package leetcode.again.L417_PacificAtlanticWaterFlow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: deadend
 * @date: 1:31 PM 3/11/17
 * @version: 1.0
 * @description:
 */


public class Solution {
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

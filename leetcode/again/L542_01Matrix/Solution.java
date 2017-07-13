package leetcode.again.L542_01Matrix;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: deadend
 * @date: 10:36 PM 02/04/2017
 */


public class Solution {
    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        int m = matrix.size();
        int n = matrix.get(0).size();
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix.get(i).get(j) == 0) {
                    queue.offer(new int[] {i, j});
                } else {
                    matrix.get(i).set(j, -1);
                }
            }
        }

        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] c = queue.poll();
            for (int[] d : dir) {
                int nx = c[0] + d[0];
                int ny = c[1] + d[1];
                int nd = matrix.get(c[0]).get(c[1]) + 1;
                // 或者
                // if (nx < 0 || ny < 0 || nx >= m || ny >= n || matrix.get(nx).get(ny) <= nd) {
                if (nx < 0 || ny < 0 || nx >= m || ny >= n || matrix.get(nx).get(ny) != -1) {
                    continue;
                }
                matrix.get(nx).set(ny, nd);
                queue.offer(new int[] {nx, ny});
            }
        }
        return matrix;
    }
}

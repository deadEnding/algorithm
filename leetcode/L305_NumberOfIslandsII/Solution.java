package leetcode.L305_NumberOfIslandsII;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 1:36 PM 3/13/17
 * @version: 1.0
 * @description:
 */


public class Solution {

    class UF {
        int count;
        int[] parent;

        public UF(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int findRoot(int id) {
            while (id != parent[id]) {
                parent[id] = parent[parent[id]];
                id = parent[id];
            }
            return id;
        }

        public void union(int pid, int qid) {
            int pRoot = findRoot(pid);
            int qRoot = findRoot(qid);
            if (pRoot == qRoot) {
                return;
            }
            parent[pRoot] = qRoot;
            count--;
        }
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new LinkedList<>();
        UF uf = new UF(m * n);
        int[][] matrix = new int[m][n];
        for (int[] p : positions) {
            if (matrix[p[0]][p[1]] == 1) {
                continue;
            }

            matrix[p[0]][p[1]] = 1;
            uf.count++;
            int id = p[0] * n + p[1];
            if (p[0] - 1 >= 0 && matrix[p[0] - 1][p[1]] == 1)
                uf.union(id, id - n);

            if (p[0] + 1 < m && matrix[p[0] + 1][p[1]] == 1)
                uf.union(id, id + n);

            if (p[1] - 1 >= 0 && matrix[p[0]][p[1] - 1] == 1)
                uf.union(id, id - 1);

            if (p[1] + 1 < n && matrix[p[0]][p[1] + 1] == 1)
                uf.union(id, id + 1);

            result.add(uf.count);
        }
        return result;
    }
}

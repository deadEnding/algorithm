package leetcode.again.L305_NumberOfIslandsII;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 9:25 PM 3/18/17
 * @version: 1.0
 * @description:
 */


public class SolutionAgain {

    class UF {
        int[] parent;
        int count;

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

        public void union(int p, int q) {
            int pRoot = findRoot(p);
            int qRoot = findRoot(q);
            if (pRoot == qRoot) {
                return;
            }

            parent[pRoot] = qRoot;
            count--;
        }
    }


    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        UF uf = new UF(m * n);
        int[][] matrix = new int[m][n];
        List<Integer> result = new LinkedList<>();

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

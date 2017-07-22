package leetcode.L323_NumberOfConnectedComponentsInAnUndirectedGraph;

/**
 * @author: deadend
 * @date: 2:20 PM 3/13/17
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
            count = n;
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
            if (pRoot != qRoot) {
                parent[pRoot] = qRoot;
                count--;
            }
        }
    }

    public int countComponents(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int[] e : edges) {
            uf.union(e[0], e[1]);
        }
        return uf.count;
    }
}

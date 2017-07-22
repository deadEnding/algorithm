package leetcode.L261_GraphValidTree;

/**
 * @author: deadend
 * @date: 9:58 PM 3/12/17
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

        public boolean union(int pid, int qid) {
            int pRoot = findRoot(pid);
            int qRoot = findRoot(qid);
            if (pRoot ==  qRoot) {
                return false;
            }
            parent[pRoot] = qRoot;
            count--;
            return true;
        }
    }

    public boolean validTree(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int[] e : edges) {
            if (!uf.union(e[0], e[1])) {
                return false;
            }
        }
        return uf.count == 1;
    }

    public static void main(String[] args) {
        int[][] e = {{0,1},{0,2},{2,3},{2,4}};
        System.out.println(new Solution().validTree(5, e));
    }
}

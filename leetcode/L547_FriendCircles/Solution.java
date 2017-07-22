package leetcode.L547_FriendCircles;

/**
 * @author: deadend
 * @date: 10:02 AM 03/04/2017
 */


public class Solution {

    class UF {
        int count;
        int[] parent;

        public UF(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int id) {
            while (parent[id] != id) {
                parent[id] = parent[parent[id]];
                id = parent[id];
            }
            return id;
        }

        public void union(int pid, int qid) {
            int proot = find(pid);
            int qroot = find(qid);
            if (proot != qroot) {
                parent[proot] = qroot;
                count--;
            }
        }
    }

    public int findCircleNum(int[][] M) {
        final int n = M.length;
        UF uf = new UF(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count;
    }
}

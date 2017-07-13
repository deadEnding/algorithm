package hihocoder.practice.P14.Q3;

import java.util.*;

public class Main {

    static class UF {

        int count;

        int[] parent;

        public UF(int n) {
            count = n;
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

        public boolean isConnected(int pid, int qid) {
            return findRoot(pid) == findRoot(qid);
        }

        public void union(int pid, int qid) {
            int pRoot = findRoot(pid);
            int qRoot = findRoot(qid);
            if (pRoot == qRoot) {
                return;
            }
            count--;
            parent[pRoot] = qRoot;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> tmp = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] id = new int[n + 1];
        int[] od = new int[n + 1];

        ArrayList<int[]> edges = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int f = sc.nextInt(), t = sc.nextInt();
            edges.add(new int[] {f, t});
        }

        for (int i = 0; i < edges.size(); i++) {
            UF uf = new UF(n);
            for (int j = 0; j < edges.size(); j++) {
                if (i == j)
                    continue;

                uf.union(edges.get(j)[1] - 1, edges.get(j)[0] - 1);
            }

            boolean right = true;
            for (int k = 0; k < n; k++) {
                if (uf.findRoot(k) != 0) {
                    right = false;
                    break;
                }
            }

            if (uf.count == 1 && right) {
                tmp.add(i + 1);
            }
        }

        for (int i = 0; i < tmp.size(); i++) {
            if (i != 0)
                System.out.print(" ");
            System.out.print(tmp.get(i));
        }
        System.out.println();
    }
}

package hihocoder.practice.P12.Q3;

import java.util.Scanner;

/**
 * @author: deadend
 * @date: 2:29 PM 03/04/2017
 */


public class Main {

    static class UF {
        int[] parent;
        int count;

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        char[][] b = new char[m][];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextLine().toCharArray();
        }

        UF uf = new UF(n * m * 4);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int id = 4 * (i * n + j);
                if (b[i][j] == '/' || b[i][j] == ' ') {
                    uf.union(id, id + 1);
                    uf.union(id + 2, id + 3);
                }

                if (b[i][j] == '\\' || b[i][j] == ' ') {
                    uf.union(id, id + 3);
                    uf.union(id + 1, id + 2);
                }

                if (j > 0)
                    uf.union(id, id - 2);
                if (i > 0)
                    uf.union(id + 1, id - 4 * n + 3);
                if (j < n - 1)
                    uf.union(id + 2, id + 4);
                if (i < m - 1)
                    uf.union(id + 3, id + 4 * n + 1);
            }
        }
        System.out.println(uf.count);
    }
}

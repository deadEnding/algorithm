package hihocoder.practice.P11.C;

import java.util.Scanner;

public class Main {

    static class UF {
        int count;
        int[] parent;

        public UF(int n) {
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
                count--;
                parent[proot] = qroot;
            }
        }
    }

    private static int L = 1000;

    private static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static boolean reachable(int x, int y) {
        return x >= 0 && y >= 0 && x < L && y < L;
    }

    public static void main(String[] args) {
        int[][] m = new int[L][L];
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        UF uf = new UF(L * L);
        int area = 0;
        int edges = 0;
        while (n-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (m[x][y] == 1) {
                continue;
            }

            m[x][y] = 1;
            uf.count++;
            area++;

            int id = x * L + y;
            for (int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];
                if (reachable(nx, ny) && m[nx][ny] == 1) {
                    edges++;
                    uf.union(id, nx * L + ny);
                }
            }

            System.out.println(String.format("%d %d %d", uf.count, area, 4 * area - 2 * edges));
        }
    }
}

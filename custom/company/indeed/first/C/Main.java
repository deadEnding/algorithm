package custom.company.indeed.first.C;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static int cnt = 0;
    private static int n, m;

    public static boolean check(ArrayList<int[]> es, boolean[] got) {
        UnionFind ufind = new UnionFind(n);

        for (int i = 0; i < es.size(); i++) {
            if (got[i]) {
                int[] e = es.get(i);
                ufind.union(e[0], e[1]);
            }
        }

        return ufind.areas == 1;
    }

    public static void solve(int ix, ArrayList<int[]> es, boolean[] got) {
        if (ix == es.size()) {
            if (check(es, got)) {
                cnt++;
            }
            return;
        }

        got[ix] = true;
        solve(ix + 1, es, got);
        got[ix] = false;

        solve(ix + 1, es, got);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        HashSet<String> fb = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            fb.add(Math.min(x, y) + "|" + Math.max(x, y));
        }

        ArrayList<int[]> es = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String s = i + "|" + j;
                if (!fb.contains(s))
                    es.add(new int[] {i, j});
            }
        }

        solve(0, es, new boolean[es.size()]);
        System.out.println(cnt);
    }

    static class UnionFind {
        private int areas = 0;
        private int[] prt;

        public UnionFind(int n) {
            prt = new int[n];
            for (int i = 0; i < n; i++) {
                prt[i] = i;
            }
            areas = n;
        }

        public int find(int id) {
            while (id != prt[id]) {
                prt[id] = prt[prt[id]];
                id = prt[id];
            }
            return id;
        }

        public void union(int x, int y) {
            int xp = find(x);
            int yp = find(y);
            if (xp != yp) {
                prt[xp] = yp;
                areas--;
            }
        }
    }

}

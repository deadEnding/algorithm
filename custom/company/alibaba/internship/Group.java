package custom.company.alibaba.internship;

import java.util.ArrayList;
import java.util.Scanner;

public class Group {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        boolean[] ok = new boolean[n + 1];
        boolean[][] want = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            String line = sc.nextLine();
            if (line.equals("self")) {
                want[i][i] = true;
                continue;
            }

            String[] tos = line.split(" ");
            for (String t : tos) {
                int x = Integer.valueOf(t);
                want[i][x] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            ok[i] = true;
            for (int j = 1; j <= n; j++) {
                if (want[i][j] && !want[j][i]) {
                    ok[i] = false;
                    break;
                }
            }
        }

        boolean[] grouped = new boolean[n + 1];
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (grouped[i] || !ok[i])
                continue;

            ArrayList<Integer> cg = new ArrayList<>();
            cg.add(i);
            boolean can = true;
            for (int j = 1; j <= n; j++) {
                if (want[i][j] && !ok[j]) {
                    can = false;
                    break;
                }

                if (want[i][j] && i != j) {
                    cg.add(j);
                }
            }

            if (can) {
                g.add(cg);
                for (int k : cg)
                    grouped[k] = true;
            }
        }

        if (g.size() == 0) {
            System.out.println("na");
            return;
        }

        for (int i = 0; i < g.size(); i++) {
            if (i != 0) {
                System.out.print(",");
            }
            for (int j = 0; j < g.get(i).size(); j++) {
                if (j != 0)
                    System.out.print(" ");
                System.out.print(g.get(i).get(j));
            }
        }
    }
}

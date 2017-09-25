package custom.company.netease.games.B;

import java.util.Scanner;

public class Main {

    private static int m, n;
    private static char[][] board;
    private static int count;

    public static void dfs(int x, int y, int ix, String w, int d) {
        if (x < 0 || y < 0 || x >= m || y >= n) {
            return;
        }

        if (board[x][y] != w.charAt(ix)) {
            return;
        }

        if (ix == w.length() - 1) {
            count++;
            return;
        }

        if (d == 0) {
            dfs(x + 1, y, ix + 1, w, d);
        } else if (d == 1) {

            dfs(x, y + 1, ix + 1, w, d);
        } else {
            dfs(x + 1, y + 1, ix + 1, w, d);

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cs = Integer.valueOf(sc.nextLine());

        for (int _c = 0; _c < cs; _c++) {
            String[] mn = sc.nextLine().split(" ");
            m = Integer.valueOf(mn[0]);
            n = Integer.valueOf(mn[1]);
            board = new char[m][];
            for (int i = 0; i < m; i++) {
                board[i] = sc.nextLine().toCharArray();
            }

            String word = sc.nextLine();

            count = 0;
            for (int i = 0; i < m ; i++) {
                for (int j = 0; j < n; j++) {
                    dfs(i, j, 0, word, 0);
                    dfs(i, j, 0, word, 1);
                    dfs(i, j, 0, word, 2);
                }
            }
            System.out.println(count);
        }

    }
}

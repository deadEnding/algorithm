package custom.company.google.kickstart.roundC.B;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class XSquared {

    private static int n;
    private static char[][] board;

    private static boolean solve() {
        ArrayList<Integer>[] row = new ArrayList[n];
        ArrayList<Integer>[] col = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            row[i] = new ArrayList<>();
            col[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    row[i].add(j);
                    col[j].add(i);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            Collections.sort(row[i]);
            Collections.sort(col[i]);
        }

        int one = 0, two = 0;
        for (int i = 0; i < n; i++) {
            if (row[i].size() == 0) {
                return false;
            } else if (row[i].size() == 1) {
                one++;
                int j = row[i].get(0);
                if (col[j].size() != 1) {
                    return false;
                }
            } else if (row[i].size() == 2) {
                two++;
                int j1 = row[i].get(0), j2 = row[i].get(1);
                if (col[j1].size() != 2 || col[j2].size() != 2) {
                    return false;
                }

                if (col[j1].get(0) != col[j2].get(0) || col[j1].get(1) != col[j2].get(1)) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return one == 1 && two == n - 1;
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("/Users/deadend/Downloads/B-large-practice1.in");
        System.setIn(fis);

        PrintStream ps=new PrintStream(new FileOutputStream("/Users/deadend/Downloads/B-large.out"));
        System.setOut(ps);

        Scanner sc = new Scanner(System.in);
        int cases = Integer.valueOf(sc.nextLine());
        for (int c = 1; c <= cases; c++) {
            n = Integer.valueOf(sc.nextLine());
            board = new char[n][];
            for (int i = 0; i < n; i++) {
                board[i] = sc.nextLine().toCharArray();
            }
            System.out.println(String.format("Case #%d: %s", c, solve() ? "POSSIBLE" : "IMPOSSIBLE"));
        }
    }
}

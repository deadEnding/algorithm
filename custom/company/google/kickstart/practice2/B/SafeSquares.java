package custom.company.google.kickstart.practice2.B;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class SafeSquares {

    public static void main(String[] args) throws FileNotFoundException {
//        FileInputStream fis = new FileInputStream("/Users/deadend/Downloads/B-small-practice.in");
//        PrintStream ps=new PrintStream(new FileOutputStream("/Users/deadend/Downloads/B-small.out"));
        FileInputStream fis = new FileInputStream("/Users/deadend/Downloads/B-large-practice.in");
        PrintStream ps=new PrintStream(new FileOutputStream("/Users/deadend/Downloads/B-large.out"));
        System.setIn(fis);
        System.setOut(ps);

        Scanner sc = new Scanner(System.in);
        int cases = Integer.valueOf(sc.nextLine());
        for (int _c = 1; _c <= cases; _c++) {
            String[] rck = sc.nextLine().split(" ");
            int r = Integer.valueOf(rck[0]);
            int c = Integer.valueOf(rck[1]);
            int k = Integer.valueOf(rck[2]);

            int[][] grid = new int[r][c];
            for (int i = 0; i < k; i++) {
                String[] xy = sc.nextLine().split(" ");
                grid[Integer.valueOf(xy[0])][Integer.valueOf(xy[1])] = 1;
            }

            long total = 0;
            long[][] dp = new long[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (grid[i][j] == 1) {
                        continue;
                    }

                    long up = i == 0 ? 0 : dp[i - 1][j];
                    long left = j == 0 ? 0 : dp[i][j - 1];
                    long leftup = i == 0 || j == 0 ? 0 : dp[i - 1][j - 1];
                    dp[i][j] = Math.min(Math.min(up, left), leftup) + 1L;
                    total += dp[i][j];
                }
            }

            System.out.println(String.format("Case #%d: %d", _c, total));
        }
    }
}

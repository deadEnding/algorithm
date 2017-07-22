package custom.company.google.kickstart.roundB.C;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * dp[i][j][0-k] 记忆化
 */

public class ChristmasTree {

    private static int n, m, k;
    private static char[][] board;

    private static int maxDepth(int i, int j) {
        if (board[i][j] == '.') {
            return 0;
        }

        int depth = 1;
        for (; i + depth < n; depth++) {
            if (j - depth < 0 || j + depth >= m) {
                return depth;
            }

            for (int k = j - depth; k <= j + depth; k++) {
                if (board[i + depth][k] != '#') {
                    return depth;
                }
            }
        }

        return depth;
    }

    private static int solve() {
        int[][] maxDepth = new int[n][m];
        int[][][] dp = new int[n][m][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxDepth[i][j] = maxDepth(i, j);
                dp[i][j][1] = maxDepth[i][j] * maxDepth[i][j];
            }
        }

        for (int kk = 2; kk <= k; kk++) {
            for (int i = n - 1; i >= 0; i--) {
                for (int j = 0; j < m; j++) {
                    for (int d = 1; d <= maxDepth[i][j] && i + d < n; d++) {
                        for (int l = j - d + 1; l <= j + d - 1; l++) {
                            if (dp[i + d][l][kk -1] > 0) {
                                dp[i][j][kk] = Math.max(dp[i][j][kk], d * d + dp[i + d][l][kk -1]);
                            }
                        }
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, dp[i][j][k]);
            }
        }
        return max;
    }

    public static void main(String[] args) throws FileNotFoundException {
//        FileInputStream fis = new FileInputStream("/Users/deadend/Downloads/C-small-practice1.in");
//        PrintStream ps=new PrintStream(new FileOutputStream("/Users/deadend/Downloads/C-small.out"));
        FileInputStream fis = new FileInputStream("/Users/deadend/Downloads/C-large-practice1.in");
        PrintStream ps=new PrintStream(new FileOutputStream("/Users/deadend/Downloads/C-large.out"));
        System.setIn(fis);
        System.setOut(ps);

        Scanner sc = new Scanner(System.in);
        int cases = Integer.valueOf(sc.nextLine());

        for (int c = 1; c <= cases; c++) {
            String[] nmk = sc.nextLine().split(" ");
            n = Integer.valueOf(nmk[0]);
            m = Integer.valueOf(nmk[1]);
            k = Integer.valueOf(nmk[2]);
            board = new char[n][];
            for (int r = 0; r < n; r++) {
                board[r] = sc.nextLine().toCharArray();
            }

            System.out.println(String.format("Case #%d: %d", c, solve()));
        }
    }
}

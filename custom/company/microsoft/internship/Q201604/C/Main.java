package custom.company.microsoft.internship.Q201604.C;

import java.util.Scanner;

/**
 * @author: deadend
 * @date: 1:34 PM 30/03/2017
 */


public class Main {

    private static final int MAX = 20000;

    private static int cvt(char c) {
        return c == 'b' ? 1 : 0;
    }

    private static int resolve(char[][] b, int n, int m) {
        int[][][] dp = new int[n][m][2];

        dp[n - 1][m - 1][0] = dp[n - 1][m - 1][1] = cvt(b[n - 1][m - 1]);
        for (int i = n - 2; i >= 0; i--) {
            dp[i][m - 1][0] = dp[i][m - 1][1] = dp[i + 1][m - 1][1] + cvt(b[i + 1][m - 1]);
        }

        for (int j = m - 2; j >= 0; j--) {
            dp[n - 1][j][0] = dp[n - 1][j][1] = dp[n - 1][j + 1][0] + cvt(b[n - 1][j + 1]);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                if (b[i][j + 1] != 'b') {
                    dp[i][j][0] = Math.min(dp[i][j + 1][0], dp[i + 1][j][1] + 1);
                } else {
                    dp[i][j][0] = Math.min(dp[i][j + 1][0] + 1, dp[i + 1][j][1] + cvt(b[i + 1][j]));
                }

                if (b[i + 1][j] != 'b') {
                    dp[i][j][1] = Math.min(dp[i + 1][j][1], dp[i][j + 1][0] + 1);
                } else {
                    dp[i][j][1] = Math.min(dp[i + 1][j][1] + 1, dp[i][j + 1][0] + cvt(b[i][j + 1]));
                }
            }
        }

        return dp[0][0][0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nm = sc.nextLine().split(" ");
        int n = Integer.valueOf(nm[0]);
        int m = Integer.valueOf(nm[1]);

        char[][] b = new char[n][];
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextLine().toCharArray();
        }

        System.out.println(resolve(b, n, m));
    }
}

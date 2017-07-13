package custom.company.jd.Q2;

import java.util.Scanner;

public class Main {

    public static double solve(double[] p) {
        final int n = p.length;
        double[][] dp = new double[n + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][0] = dp[i - 1][0] * (1 - p[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j - 1] * p[i - 1] + dp[i - 1][j] * (1 - p[i - 1]);
                }
            }
        }

        double ps = 0;
        for (int i = 0; i <= n; i++) {
            if (10 * i >= 6 * n) {
                ps += dp[n][i];
            }
        }
        return ps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] p = new double[n];
        for (int i = 0; i < n; i++) {
            p[i] = (double) sc.nextInt() / 100;
        }
        System.out.println(String.format("%.5f", solve(p)));
    }
}

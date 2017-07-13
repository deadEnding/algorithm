package hihocoder.practice.P14.Q2;

import java.util.Scanner;

public class Main {

    public static double solve(int n, int m, double[] p) {
        double[][] dp = new double[n + 1][m + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] * (1 - p[i - 1]);
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j - 1] * p[i - 1] + dp[i - 1][j] * (1 - p[i - 1]);
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        double[] p = new double[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextDouble();
        }

        System.out.println(solve(n, m, p));
    }
}

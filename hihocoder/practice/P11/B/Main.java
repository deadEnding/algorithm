package hihocoder.practice.P11.B;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int resolve(int[] v, int[] p, int n, int m) {
        final int STATES = 1 << m;
        int[][] dp = new int[n + 1][STATES];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < STATES; j++) {
                if (dp[i - 1][j] < 0)
                    continue;
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                int s1 = j ^ p[i - 1];
                dp[i][s1] = Math.max(dp[i][s1], dp[i - 1][j] + v[i - 1]);
            }
        }

        return dp[n][STATES - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] v = new int[n];
            int[] p = new int[n];
            int m = sc.nextInt();
            for (int i = 0; i < n; i++) {
                v[i] = sc.nextInt();
                int pcnt = sc.nextInt();
                for (int j = 0; j < pcnt; j++) {
                    p[i] |= (1 << (sc.nextInt() - 1));
                }
            }

            System.out.println(resolve(v, p, n, m));
        }
    }
}

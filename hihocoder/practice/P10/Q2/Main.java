package hihocoder.practice.P10.Q2;

import java.util.Scanner;

/**
 * @author: deadend
 * @date: 1:03 PM 3/19/17
 * @version: 1.0
 * @description:
 */


public class Main {

    private static int BASE = 1000000007;

    private static long resolve(int n) {
        long[][] dp = new long[n + 1][2];

        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] += (dp[i - 1][0] * 2) % BASE;
            dp[i][1] += (dp[i - 1][1] * 2) % BASE;
            if (i >= 4) {
                dp[i][0] -= dp[i - 4][0];
                dp[i][1] -= dp[i - 4][0] + dp[i - 4][1];
            } else if (i == 3) {
                dp[i][0] -= dp[i - 3][0];
                dp[i][1] -= dp[i - 3][1];
            }
            dp[i][1] += dp[i - 1][0];

            dp[i][0] = (dp[i][0] + BASE) % BASE;
            dp[i][1] = (dp[i][1] + BASE) % BASE;
        }
        return (dp[n][0] + dp[n][1]) % BASE;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(resolve(sc.nextInt()));
    }
}

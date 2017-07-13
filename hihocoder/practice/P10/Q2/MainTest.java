package hihocoder.practice.P10.Q2;

import java.util.Scanner;

/**
 * @author: deadend
 * @date: 11:55 AM 3/19/17
 * @version: 1.0
 * @description:
 */


public class MainTest {

    private static int BASE = 1000000007;

    private static int resovle(int n) {
        int[][] nodp = new int[n][2];
        nodp[0][0] = nodp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            nodp[i][0] = nodp[i - 1][0] + nodp[i - 1][1];
            nodp[i][0] %= BASE;
            nodp[i][1] = nodp[i - 1][0] + (i >= 2 ? nodp[i - 2][0] : 1);
            nodp[i][1] %= BASE;
        }

        int[][] dp = new int[n][3];
        dp[0][0] = dp[0][1] = dp[0][2] = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2];
            dp[i][0] %= BASE;
            dp[i][1] = dp[i - 1][0] + (i >= 2 ? dp[i - 2][0] + dp[i - 2][2] : 1) + dp[i - 1][2];
            dp[i][1] %= BASE;
            dp[i][2] = nodp[i - 1][0] + nodp[i - 1][1];
            dp[i][2] %= BASE;
        }
        return (dp[n - 1][0] + dp[n - 1][1] + dp[n - 1][2]) % BASE;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(resovle(sc.nextInt()));
    }
}

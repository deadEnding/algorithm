package hihocoder.library.L1038;

import java.util.Scanner;

/**
 * @author: deadend
 * @date: 5:13 PM 31/03/2017
 */

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] w = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        int[] dp = new int[c + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = c; j >= 0; j--) {
                if (j >= w[i]) {
                    dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
                }
            }
        }
        System.out.println(dp[c]);
    }
}

/*
class TimeoutMain {

    public static void Main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] w = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        int[][] dp = new int[n + 1][c + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= c; j++) {
                if (j < w[i]) {
                    dp[i][j] = dp[i + 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j - w[i]] + v[i]);
                }
            }
        }
        System.out.println(dp[0][c]);
    }
}
*/

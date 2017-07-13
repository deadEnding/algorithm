package hihocoder.library.L1044;

import java.util.Scanner;

/**
 * @author: deadend
 * @date: 11:12 AM 04/04/2017
 */


public class Main {

    // 初始化各状态值是否满足1的个数小于q
    public static boolean[] init(int m, int q) {
        boolean[] lte = new boolean[1 << m];
        for (int i = 0; i < (1 << m); i++) {
            int cnt = 0;
            for (int j = i; j > 0; j >>= 1) {
                cnt += j & 1;
            }
            lte[i] = cnt <= q;
        }
        return lte;
    }

    public static int resolve(int n, int m, int q, int[] w, boolean[] lte) {
        int[][] dp = new int[n + 1][1 << m];

        // 理论上应该dp[0] 只有 dp[0][0]的状态才是合理，但由于dp[0]里除dp[0][0]外的
        // 不合理状态不可能得到比dp[0][0]更大的解，因此初始状态是否初始化没有关系
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < (1 << m); j++) {
                int s0 = j >> 1;
                dp[i][s0] = Math.max(dp[i][s0], dp[i - 1][j]);       // 存在多次转移到dp[i][s0]，因此取max，下同

                int s1 = (1 << (m - 1)) | (j >> 1);
                if (lte[s1]) {
                    dp[i][s1] = Math.max(dp[i][s1], dp[i - 1][j] + w[i - 1]);
                }
            }
        }

        int max = 0;
        for (int j = 0; j < (1 << m); j++) {
            max = Math.max(max, dp[n][j]);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();

        boolean[] lte = init(m, q);

        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        System.out.println(resolve(n, m, q, w, lte));
    }
}

package custom.company.netease.T20170812;

import java.util.Scanner;

/**
 * Created by yuhui.zzc on 12/08/2017.
 */
public class FavoriteSequence {

    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        if (n == 0) {
            System.out.println(0);
            return;
        }

        long[][] dp = new long[n + 1][k + 1];
        for (int j = 1; j <= k; j++) {
            dp[1][j] = 1;
        }

        for (int i = 2; i <= n; i++) {
            long sum = 0L;
            for (int j = 1; j <= k; j++) {
                sum += dp[i - 1][j];
                sum %= MOD;
            }

            for (int j = 1; j <= k; j++) {
                long rmSum = 0L;
                for (int z = j + j; z <= k; z += j) {
                    rmSum += dp[i - 1][z];
                    rmSum %= MOD;
                }

                dp[i][j] = (sum - rmSum + MOD) % MOD;
            }
        }

        long sum = 0L;
        for (int j = 1; j <= k; j++) {
            sum += dp[n][j];
            sum %= MOD;
        }

        System.out.println(sum);
    }
}

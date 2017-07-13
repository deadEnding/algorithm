package custom.CC150.CH9;

import java.util.Arrays;

/**
 * @author: deadend
 * @date: 9:54 AM 12/30/16
 * @version: 1.0
 * @description:
 */


public class CoinChange {
    private int getChangeWay(int n, int[] coins, int ix) {
        if (n == 0) {
            return 1;
        }

        if (ix < 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; coins[ix] * i <= n; i++) {
            count += getChangeWay(n - coins[ix] * i, coins, ix - 1);
        }
        return count;
    }

    public int getChangeWay(int n, int[] coins) {
        Arrays.sort(coins);
        return getChangeWay(n, coins, coins.length - 1);
    }

    public static void main(String[] args) {
        int[] coins = {1,5};
        System.out.println(new CoinChange().getChangeWay(0, coins));
    }
}

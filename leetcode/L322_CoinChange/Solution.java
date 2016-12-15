package leetcode.L322_CoinChange;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author: deadend
 * @date: 8:47 PM 12/15/16
 * @version: 1.0
 * @description:
 */

public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            dp[i] = -1;
            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != -1) {
                    dp[i] = dp[i] == -1 ? dp[i - coin] + 1 : Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount];
    }
}

// 错误解法，去掉参数ix即正确，为啥？
class WrongSolution {
    private int coinChange(int[] coins, int ix,int amount, HashMap<Integer, Integer> map) {
        if (amount <= 0) {
            return amount == 0 ? 0 : -1;
        }

        if (!map.containsKey(amount)) {
            int min = -1;
            for (int i = ix; i >= 0; i--) {
                if (amount >= coins[i]) {
                    int m = coinChange(coins, i, amount - coins[i], map);
                    if (m != -1) {
                        min = min == - 1 ? m + 1 : Math.min(min, m + 1);
                    }
                }
            }
            map.put(amount, min);
        }
        return map.get(amount);
    }

    public int coinChange(int[] coins, int amount) {
        HashMap<Integer, Integer> map = new HashMap<>();
        return coinChange(coins, coins.length - 1, amount, map);
    }

    public static void main(String[] args) {
        int[] coins = {3,7,405,436};
        int amount = 8839;
        System.out.println(new DPSolution().coinChange(coins, amount));
    }
}

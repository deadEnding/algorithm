package leetcode.again.L322_CoinChange;

/**
 * @author: deadend
 * @date: 9:57 AM 3/1/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = -1;
            for (int c : coins) {
                int j = i - c;
                if (j >= 0 && dp[j] != -1) {
                    dp[i] = Math.min(dp[i] == -1 ? Integer.MAX_VALUE : dp[i], dp[j] + 1);
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {12};
        System.out.println(new Solution().coinChange(coins, 11));
    }
}

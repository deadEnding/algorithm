package leetcode.L123_BestTimeToBuyAndSellStockIII;

/**
 * @author: deadend
 * @date: P10:56 AM 11/22/16
 * @version: 1.0
 * @description:
 */

public class Solution {
    public int maxProfit(int[] prices) {
        int k = 2;
        final int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        int[][] dp = new int[k + 1][n + 1];

        int max = 0;
        for (int i = 1; i <= k ;i++) {
            int subMax = - prices[0];
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j - 1] + subMax);
                subMax = Math.max(subMax, dp[i - 1][j] - prices[j - 1]);
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }
}


class OldSolution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        final int n = prices.length;
        int[] f = new int[n];
        int[] g = new int[n];

        for (int i = 1, min = prices[0]; i < n; i++) {
            min = Math.min(min, prices[i]);
            f[i] = Math.max(f[i - 1], prices[i] - min);
        }

        for (int i = n - 2, max = prices[n - 1]; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            g[i] = Math.max(g[i + 1], max - prices[i]);
        }

        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, f[i] + (i + 1 < prices.length ? g[i + 1] : 0));
        }
        return profit;
    }
}

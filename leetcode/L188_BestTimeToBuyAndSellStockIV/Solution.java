package leetcode.L188_BestTimeToBuyAndSellStockIV;

/**
 * @author: deadend
 * @date: 12:35 PM 12/8/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }

    public int maxProfit(int k, int[] prices) {
        final int n = prices.length;
        if (n <= 1) {
            return 0;
        }

        if (k >= n / 2) {
            return quickSolve(prices);
        }

        int[][] dp = new int[2][n + 1];
        int max = 0;
        for (int i = 1; i <= k ;i++) {
            int subMax = -prices[0];
            for (int j = 1; j <= n; j++) {
                dp[i % 2][j] = Math.max(dp[i % 2][j - 1], prices[j - 1] + subMax);
                subMax = Math.max(subMax, dp[(i - 1) % 2][j] - prices[j - 1]);
                max = Math.max(max, dp[i % 2][j]);
            }
        }

        return max;
    }
}

class OldSolution {
    private int quickSolve(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            profit += diff > 0 ? diff : 0;
        }
        return profit;
    }

    public int maxProfit(int k, int[] prices) {
        final int n = prices.length;

        if (k >= n / 2) {
            return quickSolve(prices);
        }

        // global[i][j]: 前i天进行了j次交易的最大收益
        // local[i][j]: 第j次交易在第i天完成的最大收益
        int[][] global = new int[n][k + 1];
        int[][] local  = new int[n][k + 1];
        for (int i = 1; i < n; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = k; j >= 1; j--) {
                local[i][j] = Math.max(global[i - 1][j - 1] + Math.max(diff, 0), local[i - 1][j] + diff);
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
            }
        }
        return global[n - 1][k];
    }
}

// Wrong
class BasicSolution {
    private int quickSolve(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            profit += diff > 0 ? diff : 0;
        }
        return profit;
    }

    public int maxProfit(int k, int[] prices) {
        final int n = prices.length;

        if (k >= n / 2) {
            return quickSolve(prices);
        }

        int[][] profit = new int[k + 1][n];
        for (int i = 1; i < k; i++) {
            int boughtMax = -prices[0];
            for (int j = 1; j < n; j++) {
                profit[i][j] = Math.max(profit[i][j - 1], boughtMax + prices[j]);
                boughtMax = Math.max(boughtMax, profit[i - 1][j - 1] - prices[j]);  // 是否在当天买入
            }
        }
        return profit[k][n - 1];
    }
}

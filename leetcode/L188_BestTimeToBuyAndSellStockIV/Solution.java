package leetcode.L188_BestTimeToBuyAndSellStockIV;

/**
 * @author: deadend
 * @date: 12:35 PM 12/8/16
 * @version: 1.0
 * @description:
 */

public class Solution {
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

    public static void main(String[] args) {
        int k = 2;
        int[] prices = {2,6,5,0,3};
        System.out.println(new Solution().maxProfit(k, prices));
    }
}

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

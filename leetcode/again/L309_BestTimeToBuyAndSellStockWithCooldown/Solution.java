package leetcode.again.L309_BestTimeToBuyAndSellStockWithCooldown;

/**
 * @author: deadend
 * @date: 8:44 AM 3/1/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int maxProfit(int[] prices) {
        final int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        int[][] f = new int[n][3];
        f[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            f[i][0] = Math.max(f[i - 1][2] - prices[i], f[i - 1][0]);
            f[i][1] = f[i - 1][0] + prices[i];
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);
        }

        return Math.max(f[n - 1][1], f[n - 1][2]);
    }

    public static void main(String[] args) {
        int[] prices = {};
        System.out.println(new Solution().maxProfit(prices));
    }
}

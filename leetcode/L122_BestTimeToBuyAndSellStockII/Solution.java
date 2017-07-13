package leetcode.L122_BestTimeToBuyAndSellStockII;

/**
 * @author: deadend
 * @date: P10:25 AM 11/22/16
 * @version: 1.0
 * @description:
 */

public class Solution {

    // 累加递增区间
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            profit += diff > 0 ? diff : 0;
        }
        return profit;
    }
}

class Solution1 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int profit = 0;
        int buy = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                continue;
            } else {
                profit += prices[i - 1] - prices[buy];
                buy = i;
            }
        }

        if (prices[prices.length - 1] > prices[buy]) {
            profit += prices[prices.length - 1] - prices[buy];
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6};
        System.out.println(new Solution().maxProfit(prices));
    }
}

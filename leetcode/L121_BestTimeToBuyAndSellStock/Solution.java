package leetcode.L121_BestTimeToBuyAndSellStock;

/**
 * @author: deadend
 * @date: 10:19 AM 11/22/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : prices) {
            min = Math.min(min, price);
            profit = Math.max(profit, price - min);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {7,6,5,3};
        System.out.println(new Solution().maxProfit(prices));
    }
}

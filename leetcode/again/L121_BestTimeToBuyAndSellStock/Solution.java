package leetcode.again.L121_BestTimeToBuyAndSellStock;


public class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0, min = Integer.MAX_VALUE; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return max;
    }
}

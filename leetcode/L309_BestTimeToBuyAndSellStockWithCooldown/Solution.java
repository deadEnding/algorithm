package leetcode.L309_BestTimeToBuyAndSellStockWithCooldown;

/**
 * @author: deadend
 * @date: 7:26 PM 12/13/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int maxProfit(int[] prices) {
        int s0 = Integer.MIN_VALUE;
        int s1 = 0;
        int s2 = 0;

        for (int price : prices) {
            int cps2 = s2;
            s2 = Math.max(s1, s2);
            s1 = s0 + price;
            s0 = Math.max(s0, cps2 - price);
        }
        return Math.max(s1, s2);
    }
}

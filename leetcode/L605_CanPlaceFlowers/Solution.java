package leetcode.again.L605_CanPlaceFlowers;


public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        final int len = flowerbed.length;

        int count = 0;
        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 0) {
                int prev = i == 0 ? 0 : flowerbed[i - 1];
                int next = i == len - 1 ? 0 : flowerbed[i + 1];
                if (prev == 0 && next == 0) {
                    count++;
                    flowerbed[i] = 1;
                }
            }
        }

        return count >= n;
    }
}


class DPSolution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        final int len = flowerbed.length;

        int[][] dp = new int[len + 1][2];
        dp[0][0] = dp[0][1] = 0;
        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 0) {
                dp[i + 1][0] = Math.max(dp[i][0], dp[i][1]);
                dp[i + 1][1] = dp[i][0] == -1 ? -1 : dp[i][0] + 1;
            } else {
                dp[i + 1][0] = -1;
                dp[i + 1][1] = dp[i][0];
            }
        }

        return Math.max(dp[len][0], dp[len][1]) >= n;
    }
}

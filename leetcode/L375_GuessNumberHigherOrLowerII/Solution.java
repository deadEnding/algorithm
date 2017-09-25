package leetcode.L375_GuessNumberHigherOrLowerII;

/**
 * @author: deadend
 * @date: 2:33 PM 3/1/17
 * @version: 1.0
 * @description:
 */


class Solution {
    private int getMaxMin(int s, int e, int[][] cache) {
        if (s >= e) {
            return 0;
        }

        if (cache[s][e] == 0) {
            cache[s][e] = Integer.MAX_VALUE;
            for (int i = s; i <= e; i++) {
                int worstCost = i + Math.max(getMaxMin(s, i - 1, cache), getMaxMin(i + 1, e, cache));
                cache[s][e] = Math.min(cache[s][e], worstCost);
            }
        }

        return cache[s][e];
    }

    public int getMoneyAmount(int n) {
        return getMaxMin(1, n, new int[n][n]);
    }
}

class BasicSolution {
    private int guaranteeWinForRange(int[][] dp, int s, int e) {
        if (s >= e) {
            return 0;
        }

        if (dp[s][e] == 0) {
            dp[s][e] = Integer.MAX_VALUE;
            for (int i = s; i <= e; i++) {   // 穷举每一种猜测，求最坏情况的花费
                int worstCost = i + Math.max(guaranteeWinForRange(dp, s, i - 1), guaranteeWinForRange(dp, i + 1, e));
                dp[s][e] = Math.min(dp[s][e], worstCost);  // 选择最坏情况下花费最小的猜测
            }
        }

        return dp[s][e];
    }

    public int getMoneyAmount(int n) {
        return guaranteeWinForRange(new int[n + 1][n + 1], 1, n);
    }
}

class OldSolution {

    private int payForRange(int[][] dp, int s, int e) {
        if (s >= e)
            return 0;

        if (dp[s][e] == 0) {
            dp[s][e] = Integer.MAX_VALUE;
            for (int i = s; i <= e; i++) {
                int max = i + Math.max(payForRange(dp, s, i -1), payForRange(dp, i + 1, e));
                dp[s][e] = Math.min(dp[s][e], max);
            }
        }
        return dp[s][e];
    }

    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return payForRange(dp, 1, n);
    }
}


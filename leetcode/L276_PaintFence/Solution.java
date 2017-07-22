package leetcode.again.L276_PaintFence;

/**
 * @author: deadend
 * @date: P10:55 AM 3/12/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int numWays(int n, int k) {
        if (n == 0 || k == 0) {
            return 0;
        }

        int[][] dp = new int[2][2];
        dp[0][0] = k;
        for (int i = 1; i < n; i++) {
            dp[i % 2][0] = (dp[(i - 1) % 2][0] + dp[(i - 1) % 2][1]) * (k - 1);
            dp[i % 2][1] = dp[(i - 1) % 2][0];
        }
        return dp[(n - 1) % 2][0] + dp[(n - 1) % 2][1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numWays(3, 2));
    }
}

class BasicSolution {
    public int numWays(int n, int k) {
        if (k == 0 || n == 0) {
            return 0;
        }

        int[][] dp = new int[n][2];
        dp[0][0] = k;
        for (int i = 1; i < n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) * (k - 1);
            dp[i][1] = dp[i - 1][0];
        }
        return dp[n - 1][0] + dp[n - 1][1];
    }
}

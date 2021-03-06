package leetcode.L070_ClimbingStairs;

/**
 * @author: deadend
 * @date: 12:48 PM 3/3/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int climbStairs(int n) {
        int[] dp = {1, 1};
        for (int i = 2; i <= n; i++) {
            dp[i % 2] += dp[(i - 1) % 2];
        }

        return dp[n % 2];
    }
}


class OldSolution {
    public int climbStairs(int n) {
        int[] f = new int[2];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            f[i % 2] += f[1 - i % 2];
        }
        return f[n % 2];
    }
}

package leetcode.L343_IntegerBreak;

/**
 * @author: deadend
 * @date: 4:05 PM 12/16/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], Math.max(dp[j], j) * Math.max(dp[i - j], i - j));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().integerBreak(25));
    }
}

class MathSolution {
    public int integerBreak(int n) {
        if (n == 2 || n == 3) {
            return n - 1;
        }

        int result = 1;
        while (n > 4) {
            result *= 3;
            n -= 3;
        }
        return result * n;
    }
}

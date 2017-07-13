package leetcode.L279_PerfectSquares;


/**
 * @author: deadend
 * @date: P10:45 PM 12/11/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new OtherSolution().numSquares(52));
    }
}

class OtherSolution {
    private int numSquares(int n, int[] mem) {
        if (n == 0) {
            return 0;
        }

        if (mem[n] == 0) {
            mem[n] = n;
            for (int i = 1; i * i <= n; i++) {
                mem[n] = Math.min(mem[n], numSquares(n - i * i, mem) + 1);
            }
        }
        return mem[n];
    }

    public int numSquares(int n) {
        int[] mem = new int[n + 1];
        return numSquares(n, mem);
    }
}
package leetcode.L312_BurstBalloons;

/**
 * @author: deadend
 * @date: 2:06 PM 12/14/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            arr[i + 1] = nums[i];
        }
        arr[0] = arr[nums.length + 1] = 1;

        final int n = arr.length;
        int[][] dp = new int[n][n];
        for (int d = 2; d < n; d++) {
            for (int i = 0; i + d < n; i++) {
                int j = i + d;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + arr[i] * arr[k] * arr[j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}

class RecusiveSolution {
    private int burst(int[] arr, int[][] mem, int i, int j) {
        if (i + 1 == j) {
            return 0;
        }

        if (mem[i][j] == 0) {
            for (int k = i + 1; k < j; k++) {
                mem[i][j] = Math.max(mem[i][j], burst(arr, mem, i, k) + burst(arr, mem, k, j) + arr[i] * arr[k] * arr[j]);
            }
        }
        return mem[i][j];
    }

    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            arr[i + 1] = nums[i];
        }
        arr[0] = arr[nums.length + 1] = 1;

        final int n = arr.length;
        int[][] mem = new int[n][n];
        return burst(arr, mem, 0, n - 1);
    }
}

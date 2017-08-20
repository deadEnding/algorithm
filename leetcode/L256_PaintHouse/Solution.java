package leetcode.L256_PaintHouse;

public class Solution {
    public int minCost(int[][] costs) {
        final int n = costs.length;
        int[][] dp = new int[2][3];
        for (int i = 0; i < n; i++) {
            dp[(i + 1) % 2][0] = Math.min(dp[i % 2][1], dp[i % 2][2]) + costs[i][0];
            dp[(i + 1) % 2][1] = Math.min(dp[i % 2][0], dp[i % 2][2]) + costs[i][1];
            dp[(i + 1) % 2][2] = Math.min(dp[i % 2][0], dp[i % 2][1]) + costs[i][2];
        }

        return Math.min(dp[n % 2][0], Math.min(dp[n % 2][1], dp[n % 2][2]));
    }
}


class SolutionWithPaintSolution {
    public int minCost(int[][] costs) {
        final int n = costs.length;
        int[][] dp = new int[2][3];
        int[][] from = new int[n + 1][3];
        for (int i = 0; i < n; i++) {
            dp[(i + 1) % 2][0] = Math.min(dp[i % 2][1], dp[i % 2][2]) + costs[i][0];
            from[i + 1][0] = dp[i % 2][1] < dp[i % 2][2] ? 1 : 2;
            dp[(i + 1) % 2][1] = Math.min(dp[i % 2][0], dp[i % 2][2]) + costs[i][1];
            from[i + 1][1] = dp[i % 2][0] < dp[i % 2][2] ? 0 : 2;
            dp[(i + 1) % 2][2] = Math.min(dp[i % 2][0], dp[i % 2][1]) + costs[i][2];
            from[i + 1][2] = dp[i % 2][0] < dp[i % 2][1] ? 0 : 1;
        }

        int min = 0;
        for (int i = 0; i < 3; i++) {
            if (dp[n % 2][i] < dp[n % 2][min]) {
                min = i;
            }
        }

        int[] solution = getPaintSolution(n, from, min);
        for (int s : solution) {
            System.out.print(s + " ");
        }
        System.out.println();

        return dp[n % 2][min];
    }

    private int[] getPaintSolution(int n, int[][] from, int last) {
        int[] solution = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            solution[i] = last;
            last = from[i + 1][last];
        }
        return solution;
    }
}

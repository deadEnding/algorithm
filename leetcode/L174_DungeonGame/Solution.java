package leetcode.again.L174_DungeonGame;


public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        final int m = dungeon.length;
        final int n = dungeon[0].length;

        int[] dp = new int[n + 1];
        dp[n] = Integer.MIN_VALUE;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dp[j] = Math.min(0, dungeon[i][j]);
                } else if (i == m - 1) {
                    dp[j] = Math.min(0, dp[j + 1] + dungeon[i][j]);
                } else {
                    dp[j] = Math.min(0, Math.max(dp[j], dp[j + 1]) + dungeon[i][j]);
                }
            }
        }

        return -dp[0] + 1;
    }

    public static void main(String[] args) {
        int[][] d = {{0,-3}};
        System.out.println(new Solution().calculateMinimumHP(d));
    }
}


class BasicSolution {
    public int calculateMinimumHP(int[][] dungeon) {
        final int m = dungeon.length;
        final int n = dungeon[0].length;

        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = Math.min(0, dungeon[m - 1][n - 1]);
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.min(0, dp[i + 1][n - 1] + dungeon[i][n - 1]);
        }

        for (int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = Math.min(0, dp[m - 1][j + 1] + dungeon[m - 1][j]);
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = Math.min(0, Math.max(dp[i + 1][j], dp[i][j + 1]) + dungeon[i][j]);
            }
        }

        return -dp[0][0] + 1;
    }
}

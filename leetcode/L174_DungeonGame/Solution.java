package leetcode.L174_DungeonGame;

/**
 * @author: deadend
 * @date: 9:27 AM 12/8/16
 * @version: 1.0
 * @description:
 */

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        final int m = dungeon.length;
        final int n = dungeon[0].length;

        int[] min = new int[n + 1];
        min[n] = Integer.MAX_VALUE;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    min[j] = Math.max(0, -dungeon[i][j]);
                } else if (i == m - 1) {
                    min[j] = Math.max(0, min[j + 1] - dungeon[i][j]);
                } else {
                    min[j] = Math.max(0, Math.min(min[j], min[j + 1]) - dungeon[i][j]);
                }
            }
        }
        return min[0] + 1;
    }

    public static void main(String[] args) {
        int[][] dungeon = {{-2, -3 , 3}, {-5, -10, 1}, {10, 30, -5}};
        System.out.println(new Solution().calculateMinimumHP(dungeon));
    }
}

class BasicSolution {
    public int calculateMinimumHP(int[][] dungeon) {
        final int m = dungeon.length;
        final int n = dungeon[0].length;

        int[][] min = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    min[i][j] = Math.max(0, -dungeon[i][j]);
                } else if (i == m - 1) {
                    min[i][j] = Math.max(0, min[i][j + 1] - dungeon[i][j]);
                } else if (j == n - 1) {
                    min[i][j] = Math.max(0, min[i + 1][j] - dungeon[i][j]);
                } else {
                    min[i][j] = Math.max(0, Math.min(min[i][j + 1], min[i + 1][j]) - dungeon[i][j]);
                }
            }
        }

        return min[0][0] + 1;
    }
}

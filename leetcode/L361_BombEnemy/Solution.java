package leetcode.L361_BombEnemy;

/**
 * @author: deadend
 * @date: 11:01 AM 3/P10/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
final int m = grid.length;
        final int n = grid[0].length;
        int max = 0;
        int re = 0;
        int[] ce = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || grid[i - 1][j] == 'W') {
                    ce[j] = 0;
                    for (int k = i; k < m && grid[k][j] != 'W'; k++) {
                        ce[j] += grid[k][j] == 'E' ? 1 : 0;
                    }
                }

                if (j == 0 || grid[i][j - 1] == 'W') {
                    re = 0;
                    for (int k = j; k < n && grid[i][k] != 'W'; k++) {
                        re += grid[i][k] == 'E' ? 1 : 0;
                    }
                }

                if (grid[i][j] == '0') {
                    max = Math.max(max, re + ce[j]);
                }
            }
        }
        return max;
    }
}


class BasicSolution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        final int m = grid.length;
        final int n = grid[0].length;

        int[][] bottom = new int[m + 1][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                bottom[i][j] = grid[i][j] == 'W' ? 0 : (grid[i][j] == 'E' ? bottom[i + 1][j] + 1 : bottom[i + 1][j]);
            }
        }

        int max = 0;
        int[] top = new int[n];
        for (int i = 0; i < m; i++) {
            int[] right = new int[n + 1];
            for (int j = n - 1; j >= 0; j--) {
                right[j] = grid[i][j] == 'W' ? 0 : (grid[i][j] == 'E' ? right[j + 1] + 1 : right[j + 1]);
            }

            int left = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    max = Math.max(max, left + right[j + 1] + top[j] + bottom[i + 1][j]);
                }
                left = grid[i][j] == 'W' ? 0 : (grid[i][j] == 'E' ? left + 1 : left);
                top[j] = grid[i][j] == 'W' ? 0 : (grid[i][j] == 'E' ? top[j] + 1 : top[j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        char[][] g = {{'0', 'E', '0', '0'}, {'E', '0', 'W', 'E'}, {'0', 'E', '0', '0'}};
        char[][] g = {{'W','W','W','W','E','0','E','0','E','0','E'},{'W','E','E','E','E','W','W','W','W','W','W'},{'E','E','W','E','W','E','E','E','E','E','E'},{'W','E','E','E','E','0','0','0','0','0','0'},{'0','0','0','0','0','E','E','E','E','E','E'}};
        System.out.println(new Solution().maxKilledEnemies(g));
    }
}

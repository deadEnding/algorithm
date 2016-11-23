package leetcode.L289_GameOfLife;

/**
 * @author: deadend
 * @date: 10:35 AM 11/23/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public void gameOfLife(int[][] board) {
        final int m = board.length;
        final int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int live = - board[i][j];
                for (int ti = Math.max(0, i - 1); ti <= Math.min(m - 1, i + 1); ti++) {
                    for (int tj = Math.max(0, j - 1); tj <= Math.min(n - 1, j + 1); tj++) {
                        live += (board[ti][tj] & 1);
                    }
                }

                if (board[i][j] == 1 && (live == 2 || live == 3)) {
                    board[i][j] |= 2;
                } else if (board[i][j] == 0 && live == 3) {
                    board[i][j] |= 2;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = (board[i][j] & 2) >> 1;
            }
        }
    }

    public static void main(String[] args) {
        int[][] borad = {{0,0,0,0,0,0},{0,0,1,1,0,0},{0,1,0,0,1,0},{0,0,1,1,0,0},{0,0,0,0,0,0}};
        new Solution().gameOfLife(borad);

        for (int[] row : borad) {
            for (int c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}

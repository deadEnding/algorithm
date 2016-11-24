package leetcode.L036_ValidSudoku;

/**
 * @author: deadend
 * @date: 3:16 PM 11/24/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public boolean isValidSudoku(char[][] board) {
        final int n = 9;
        for (int i = 0; i < n; i++) {
            boolean[] row = new boolean[n];
            boolean[] col = new boolean[n];
            boolean[] sqr = new boolean[n];

            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    if (row[board[i][j] - '1']) {
                        return false;
                    }
                    row[board[i][j] - '1'] = true;
                }

                if (board[j][i] != '.') {
                    if (col[board[j][i] - '1']) {
                        return false;
                    }
                    col[board[j][i] - '1'] = true;

                }

                int ix = i / 3 * 3 + j / 3;
                int jx = i % 3 * 3 + j % 3;
                if (board[ix][jx] != '.') {
                    if (sqr[board[ix][jx] - '1']) {
                        return false;
                    }
                    sqr[board[ix][jx] - '1'] = true;
                }
            }
        }
        return true;
    }
}

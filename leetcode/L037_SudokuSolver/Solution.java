package leetcode.L037_SudokuSolver;

/**
 * @author: deadend
 * @date: 3:43 PM 11/24/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public void solveSudoku(char[][] board) {
        solve(board, 0);
    }

    private boolean solve(char[][] board, int k) {
        if (k == 81) {
            return true;
        }

        int i = k / 9, j = k % 9;
        if (board[i][j] == '.') {
            for (char c = '1'; c <= '9'; c++) {
                board[i][j] = c;
                if (isValid(board, i, j) && solve(board, k + 1)) {
                    return true;
                }
                board[i][j] = '.';
            }
            return false;
        } else {
            return solve(board, k + 1);
        }
    }

    private boolean isValid(char[][] board, int i, int j) {
        boolean[] row = new boolean[9];
        boolean[] col = new boolean[9];
        boolean[] sqr = new boolean[9];
        for (int k = 0; k < 9; k++) {
            if (board[i][k] != '.') {
                if (row[board[i][k] - '1']) {
                    return false;
                }
                row[board[i][k] - '1'] = true;
            }

            if (board[k][j] != '.') {
                if (col[board[k][j] - '1']) {
                    return false;
                }
                col[board[k][j] - '1'] = true;
            }

            int ix = i / 3 * 3 + k / 3;
            int jx = j / 3 * 3 + k % 3;
            if (board[ix][jx] != '.') {
                if (sqr[board[ix][jx] - '1']) {
                    return false;
                }
                sqr[board[ix][jx] - '1'] = true;
            }
        }
        return true;
    }
}

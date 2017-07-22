package leetcode.L289_GameOfLife;

/**
 * @author: deadend
 * @date: 9:45 PM 3/P10/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    private int liveNeighbors(int[][] board, int x, int y) {
        int count = -(board[x][y] & 1);
        for (int i = Math.max(x - 1, 0); i <= Math.min(x + 1, board.length - 1); i++) {
            for (int j = Math.max(y - 1, 0); j <= Math.min(y + 1, board[0].length - 1); j++) {
                count += board[i][j] & 1;
            }
        }
        return count;
    }

    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        final int m = board.length;
        final int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int c = liveNeighbors(board, i, j);
                if ((board[i][j] == 1 && (c == 2 || c == 3)) || (board[i][j] == 0 && c == 3)) {
                        board[i][j] |= 2;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = (board[i][j] & 2) != 0 ? 1 : 0;
            }
        }
    }
}

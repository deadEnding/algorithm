package leetcode.again.L348_DesignTicTacToe;

/**
 * @author: deadend
 * @date: 8:45 PM 3/12/17
 * @version: 1.0
 * @description:
 */


public class TicTacToe {

    private int n;
    private int[][] rowCount;
    private int[][] colCount;
    private int[][] diagonal;
    private int win;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n = n;
        rowCount = new int[2][n];
        colCount = new int[2][n];
        diagonal = new int[2][2];
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if (win > 0) {
            return win;
        }

        if (++rowCount[player - 1][row] == n || ++colCount[player - 1][col] == n) {
            return (win = player);
        }

        if (row == col && ++diagonal[player - 1][0] == n) {
            return (win = player);
        }

        if (row + col == n - 1 && ++diagonal[player - 1][1] == n) {
            return (win = player);
        }
        return 0;
    }
}

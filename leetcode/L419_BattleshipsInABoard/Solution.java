package leetcode.L419_BattleshipsInABoard;

/**
 * @author: deadend
 * @date: 10:29 AM 12/22/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return 0;
        }

        final int m = board.length;
        final int n = board[0].length;

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X' && (j == 0 || board[i][j - 1] == '.') && (i == 0 || board[i - 1][j] == '.')) {
                    count++;
                }
            }
        }
        return count;
    }
}

package leetcode.again.L419_BattleshipsInABoard;


public class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    count += (i == 0 || board[i - 1][j] == '.') && (j == 0 || board[i][j - 1] == '.') ? 1 : 0;
                }
            }
        }

        return count;
    }
}

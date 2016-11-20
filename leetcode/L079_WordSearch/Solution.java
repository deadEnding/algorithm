package leetcode.L079_WordSearch;

/**
 * @author: deadend
 * @date: 9:48 AM 11/18/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public boolean exist(char[][] board, String word) {
        final int m = board.length;
        final int n = board[0].length;

        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(0, word, i, j, board, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int ix, String word, int i, int j, char[][] board, boolean[][] visited) {
        if (ix >= word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
                || visited[i][j] || board[i][j] != word.charAt(ix)) {
            return false;
        }

        visited[i][j] = true;
        boolean ret = dfs(ix + 1, word, i - 1, j, board, visited) || (dfs(ix + 1, word, i , j - 1, board, visited)) ||
                (dfs(ix + 1, word, i + 1, j, board, visited)) || dfs(ix + 1, word, i, j + 1, board, visited);
        visited[i][j] = false;
        return ret;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D','E', 'E'}};
        System.out.println(new Solution().exist(board, "SEE"));
    }
}
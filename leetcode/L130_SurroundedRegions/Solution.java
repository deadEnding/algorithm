package leetcode.L130_SurroundedRegions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: deadend
 * @date: 4:59 PM 12/5/16
 * @version: 1.0
 * @description:
 */


public class Solution {

    class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        final int m = board.length;
        final int n = board[0].length;
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O') {
                    queue.offer(new Point(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int x = p.x, y = p.y;
            board[x][y] = 'T';

            if (x > 0 && board[x - 1][y] == 'O') {
                queue.offer(new Point(x - 1, y));
            }
            if (x < m - 1 && board[x + 1][y] == 'O') {
                queue.offer(new Point(x + 1, y));
            }
            if (y > 0 && board[x][y - 1] == 'O') {
                queue.offer(new Point(x, y - 1));
            }
            if (y < n - 1 && board[x][y + 1] == 'O') {
                queue.offer(new Point(x, y + 1));
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] == 'T' ? 'O' : 'X';
            }
        }
    }
}

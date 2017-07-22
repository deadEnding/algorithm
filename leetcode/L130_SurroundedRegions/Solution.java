package leetcode.L130_SurroundedRegions;

/**
 * @author: deadend
 * @date: 4:54 PM 3/4/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    class UF {

        private int[] parent;

        public UF(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int findRoot(int id) {
            while (id != parent[id]) {
                parent[id] = parent[parent[id]];
                id = parent[id];
            }
            return id;
        }

        public boolean isConnected(int pid, int qid) {
            return findRoot(pid) == findRoot(qid);
        }

        public void union(int pid, int qid) {
            int pRoot = findRoot(pid);
            int qRoot = findRoot(qid);
            if (pRoot == qRoot) {
                return;
            }
            parent[pRoot] = qRoot;
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        final int m = board.length, n = board[0].length;
        UF uf = new UF(m * n + 1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 'O') {
                    continue;
                }
                int p = i * n + j;
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    uf.union(p, m * n);
                } else {
                    if (board[i - 1][j] == 'O')
                        uf.union(p, p - n);
                    if (board[i + 1][j] == 'O')
                        uf.union(p, p + n);
                    if (board[i][j - 1] == 'O')
                        uf.union(p, p - 1);
                    if (board[i][j + 1] == 'O')
                        uf.union(p, p + 1);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !uf.isConnected(i * n + j, m * n)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {
//        char[][] b = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        char[][] b = {{'X','X','X'},{'X','O','X'},{'X','X','X'}};
        new Solution().solve(b);
        for (char[] chs : b) {
            for (char c : chs) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}


// Stack Overflow
class StackOverflowSolution {
    private void dfs(int x, int y, char[][] board) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != 'O') {
            return;
        }

        board[x][y] = 'T';
        dfs(x - 1, y, board);
        dfs(x + 1, y, board);
        dfs(x, y - 1, board);
        dfs(x, y + 1, board);
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) {
                    dfs(i, j, board);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}

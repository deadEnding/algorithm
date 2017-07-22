package leetcode.L200_NumberOfIslands;

/**
 * @author: deadend
 * @date: 9:22 PM 3/P10/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    private void dfs(int x, int y, char[][] grid) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != '1') {
            return;
        }

        grid[x][y] = '2';
        dfs(x + 1, y, grid);
        dfs(x - 1, y, grid);
        dfs(x, y + 1, grid);
        dfs(x, y - 1, grid);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }
}

class UnionFindSolution {

    class UF {
        int count = 0;
        int[] parent;

        public UF (char[][] grid) {
            final int m = grid.length, n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    count += grid[i][j] == '1' ? 1 : 0;
                }
            }

            parent = new int[m * n];
            for (int i = 0; i < m * n; i++) {
                parent[i] = i;
            }
        }

        public int findOldestAncestor(int id) {
            while (id != parent[id]) {
                parent[id] = parent[parent[id]];
                id = parent[id];
            }
            return id;
        }

        public boolean isConnected(int pid, int qid) {
            return findOldestAncestor(pid) == findOldestAncestor(qid);
        }

        public boolean union(int pid, int qid) {
            int pRoot = findOldestAncestor(pid);
            int qRoot = findOldestAncestor(qid);
            if (pRoot== qRoot) {
                return false;
            } else {
                parent[pRoot] = qRoot;   // 根节点合并
                count--;
                return true;
            }

        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        final int m = grid.length, n = grid[0].length;
        UF uf = new UF(grid);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0')
                    continue;

                int p = i * n + j;
                if (i - 1 >= 0 && grid[i - 1][j] == '1')
                    uf.union(p, p - n);
                if (i + 1 < m && grid[i + 1][j] == '1')
                    uf.union(p, p + n);
                if (j - 1 >= 0 && grid[i][j - 1] == '1')
                    uf.union(p, p - 1);
                if (j + 1 < n && grid[i][j + 1] == '1')
                    uf.union(p, p + 1);
            }
        }
        return uf.count;
    }

    public static void main(String[] args) {
        char[][] g = {{'1','1','1','1','1','1','1',},{'0','0','0','0','0','0','1',},{'1','1','1','1','1','0','1',},{'1','0','0','0','1','0','1',},{'1','0','1','0','1','0','1',},{'1','0','1','1','1','0','1',},{'1','1','1','1','1','1','1',}};
        UnionFindSolution unionFindSolution = new UnionFindSolution();
        System.out.println(unionFindSolution.numIslands(g));
    }
}

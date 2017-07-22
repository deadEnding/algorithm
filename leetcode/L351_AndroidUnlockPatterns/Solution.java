package leetcode.L351_AndroidUnlockPatterns;

/**
 * @author: deadend
 * @date: 4:22 PM 3/P10/17
 * @version: 1.0
 * @description:
 */


public class Solution {

    private int dfs(int ix, int[][] skip, boolean[] visited, int step) {
        if (step == 0) {
            return 0;
        }

        if (step == 1) {
            return 1;
        }

        visited[ix] = true;
        int count = 0;
        for (int i = 1; i <= 9; i++) {
            if (!visited[i] && (skip[ix][i] == 0 || visited[skip[ix][i]])) {
                count += dfs(i, skip, visited, step - 1);
            }
        }
        visited[ix] = false;
        return count;
    }

    public int numberOfPatterns(int m, int n) {
        int[][] skip = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[4][6] = skip[6][4] = 5;
        skip[7][9] = skip[9][7] = 8;
        skip[1][7] = skip[7][1] = 4;
        skip[2][8] = skip[8][2] = 5;
        skip[3][9] = skip[9][3] = 6;
        skip[1][9] = skip[9][1] = 5;
        skip[3][7] = skip[7][3] = 5;
        boolean[] visited = new boolean[10];

        int count = 0;
        for (int i = m; i <= n; i++) {
            count += dfs(1, skip, visited, i) * 4;
            count += dfs(2, skip, visited, i) * 4;
            count += dfs(5, skip, visited, i);
        }
        return count;
    }

    public static void main(String[] args) {
        int m = 1;
        int n = 3;
        System.out.println(new Solution().numberOfPatterns(m, n));
    }
}

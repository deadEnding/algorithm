package leetcode.L051_N_Queens;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 9:30 PM 11/30/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    private List<List<String>> result = new LinkedList<>();

    private String generate(int j, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(i == j ? 'Q' : '.');
        }
        return sb.toString();
    }

    private void solveNQueens(int ix, int n, boolean[] colUsed, boolean[] diagUsed,
                              boolean[] mainDiagUsed, ArrayList<String> path) {
        if (ix == n) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int j = 0; j < n; j++) {
            if (!colUsed[j] && !diagUsed[ix + j] && !mainDiagUsed[n - 1 - ix + j]) {
                colUsed[j] = diagUsed[ix + j] = mainDiagUsed[n - 1 - ix + j] = true;
                path.add(generate(j, n));
                solveNQueens(ix + 1, n, colUsed, diagUsed, mainDiagUsed, path);
                path.remove(path.size() - 1);
                colUsed[j] = diagUsed[ix + j] = mainDiagUsed[n - 1 - ix + j] = false;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        solveNQueens(0, n, new boolean[n], new boolean[2*n - 1], new boolean[2*n - 1],
                new ArrayList<String>());
        return result;
    }

    public static void main(String[] args) {
        List<List<String>> result = new Solution().solveNQueens(4);
        for (List<String> row : result) {
            for (String s : row) {
                System.out.println(s);
            }
            System.out.println();
        }
    }
}

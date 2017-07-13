package leetcode.L052_N_QueensII;


/**
 * @author: deadend
 * @date: P10:23 PM 11/30/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    private int count = 0;

    private boolean isValid(int[] colUsed, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (colUsed[i] == col || colUsed[i] + i == row + col || colUsed[i] - i == col - row) {
                return false;
            }
        }
        return true;
    }

    private void totalNQueens(int row, int[] colUsed) {
        final int n = colUsed.length;
        if (row == n) {
            count++;
            return;
        }

        for (int j = 0; j < n; j++) {
            if (isValid(colUsed, row, j)) {
                colUsed[row] = j;
                totalNQueens(row + 1, colUsed);
            }
        }
    }

    public int totalNQueens(int n) {
        totalNQueens(0, new int[n]);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().totalNQueens(4));
    }
}

package leetcode.L304_RangeSumQuery2d_Immutable;

/**
 * @author: deadend
 * @date: 11:28 AM 12/13/16
 * @version: 1.0
 * @description:
 */


public class NumMatrix {

    private int[][] sum;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        final int m = matrix.length;
        final int n = matrix[0].length;
        sum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0, s = 0; j < n; j++) {
                s += matrix[i][j];
                sum[i + 1][j + 1] = sum[i][j + 1] + s;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2 + 1][col2 + 1] - sum[row1][col2 + 1] - sum[row2 + 1][col1] + sum[row1][col1];
    }
}


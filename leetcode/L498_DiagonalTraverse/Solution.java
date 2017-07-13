package leetcode.L498_DiagonalTraverse;

/**
 * @author: deadend
 * @date: 1:26 PM 2/11/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        final int m = matrix.length;
        final int n = matrix[0].length;

        int[] result = new int[m * n];
        for (int ix = 0, k = 0; ix <= m + n - 2; ix++) {
            if (ix % 2 == 0) {
                for (int i = Math.min(ix, m - 1); i >= Math.max(ix - n + 1, 0); i--) {
                    result[k++] = matrix[i][ix - i];
                }
            } else {
                for (int i = Math.max(ix - n + 1, 0); i <= Math.min(ix, m - 1); i++) {
                    result[k++] = matrix[i][ix - i];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] m = {{1,2,3}};
        int[] result = new Solution().findDiagonalOrder(m);
        for (int i : result) {
            System.out.print(i + ",");
        }
    }
}

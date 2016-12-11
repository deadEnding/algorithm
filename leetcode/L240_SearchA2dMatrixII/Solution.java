package leetcode.L240_SearchA2dMatrixII;

/**
 * @author: deadend
 * @date: 11:02 AM 12/11/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        final int m = matrix.length;
        final int n = matrix[0].length;

        for (int i = 0, j = n - 1; i < m && j >= 0;) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{-5}};
        System.out.println(new Solution().searchMatrix(matrix, -5));
    }
}




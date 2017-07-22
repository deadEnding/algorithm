package leetcode.again.L240_SearchA2dMatrixII;

/**
 * @author: deadend
 * @date: 7:13 PM 2/28/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int r = 0, c = matrix[0].length - 1;
        while (r < matrix.length && c >= 0) {
            if (target == matrix[r][c]) {
                return true;
            } else if (target < matrix[r][c]) {
                c--;
            } else {
                r++;
            }
        }
        return false;
    }
}

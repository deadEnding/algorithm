package leetcode.L074_SearchA2dMatrix;

/**
 * @author: deadend
 * @date: P10:22 PM 11/17/16
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

        int rs = 0, ce = n - 1;
        while (rs < m && ce >= 0) {
            if (matrix[rs][ce] == target) {
                return true;
            } else if (matrix[rs][ce] < target) {
                rs++;
            } else {
                ce--;
            }
        }

        return false;
    }
}

class OldSolution {
    public boolean searchMatrix(int[][] matrix, int target) {
        final int m = matrix.length;
        final int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int i = mid / n;
            int j = mid % n;
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7}, {10,12,14,16}, {20,24,28,32}};
        System.out.println(new Solution().searchMatrix(matrix, 40));
    }
}

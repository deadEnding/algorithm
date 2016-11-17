package leetcode.L048_RotateImage;

/**
 * @author: deadend
 * @date: 12:28 PM 11/14/16
 * @version: 1.0
 * @description:
 */


public class Solution {

    public void rotate(int[][] matrix) {
        // 沿主对角线翻折
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        // 左右翻折
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length - 1 - j];
                matrix[i][matrix[0].length - 1 - j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix = {{1}};
        new Solution().rotate(matrix);
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }
}

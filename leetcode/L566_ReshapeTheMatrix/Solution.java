package leetcode.L566_ReshapeTheMatrix;


public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null || nums.length == 0 || nums[0].length == 0) {
            return nums;
        }

        final int m = nums.length;
        final int n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }

        int[][] reshaped = new int[r][c];
        for (int i = 0; i < m * n; i++) {
            reshaped[i / c][i % c] = nums[i / n][i % n];
        }
        return reshaped;
    }
}

package leetcode.L363_MaxSumOfRectangleNoLargerThanK;

import java.util.TreeSet;

/**
 * @author: deadend
 * @date: 8:37 PM 2/17/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        final int m = matrix.length, n = matrix[0].length;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            int[] row = new int[n];
            for (int j = i; j < m; j++) {
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                for (int c = 0, sum = 0; c < n; c++) {
                    row[c] += matrix[j][c];
                    sum += row[c];
                    Integer ceil = set.ceiling(sum - k);
                    if (ceil != null) {
                        max = Math.max(max, sum - ceil);
                    }
                    set.add(sum);
                }

            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] m = {{5,-4,-3,4},{-3,-4,4,5},{5,1,5,-4}};
        System.out.println(new Solution().maxSumSubmatrix(m, 8));
    }
}

package leetcode.L363_MaxSumOfRectangleNoLargerThanK;

import java.util.TreeSet;

/**
 * @author: deadend
 * @date: 9:42 AM 3/20/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        final int m = matrix.length, n = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            int[] colSum = new int[n];
            for (int j = i; j < m; j++) {
                TreeSet<Integer> set = new TreeSet();
                set.add(0);

                for (int c = 0, sum = 0; c < n; c++) {
                    colSum[c] += matrix[j][c];
                    sum += colSum[c];
                    Integer ceil = set.ceiling(sum - k);
                    if (ceil != null)
                        max = Math.max(max, sum - ceil);
                    set.add(sum);
                }
            }
        }
        return max;
    }
}

package leetcode.again.L378_KthSmallestElementInASortedMatrix;

/**
 * @author: deadend
 * @date: 4:20 PM 3/1/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            return -1;
        }

        final int n = matrix.length;

        int l = matrix[0][0];
        int r = matrix[n - 1][n - 1];
        while (l < r) {
            int m = l + (r - l) / 2;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                int j = 0;
                while ( j < n) {
                    if (matrix[i][j] > m)
                        break;
                    j++;
                }
                cnt += j;
            }
            if (cnt < k) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}

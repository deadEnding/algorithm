package leetcode.L413_ArithmeticSlices;

/**
 * @author: deadend
 * @date: 5:26 PM 3/3/17
 * @version: 1.0
 * @description:
 */

public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        final int n = A.length;
        int sum = 0;
        for (int i = 2, curr = 0; i < n; i++) {
            if ((long)A[i] + A[i - 2] == (long)A[i - 1] * 2) {
                curr++;
                sum += curr;
            } else {
                curr = 0;
            }
        }
        return sum;
    }
}

class BasicSolution {
    public int numberOfArithmeticSlices(int[] A) {
        final int n = A.length;
        if (n < 3) {
            return 0;
        }

        int count = 0;
        int[][] f = new int[n][2];
        for (int i = 2; i < n; i++) {
            if (f[i - 1][0] == 0) {
                if ((long)A[i] + A[i - 2] == (long)A[i - 1] * 2) {
                    f[i][0] = 1;
                    f[i][1] = A[i] - A[i - 1];
                }
            } else {
                if ((long)A[i] - A[i - 1] == f[i - 1][1]) {
                    f[i][0] = f[i - 1][0] + 1;
                    f[i][1] = A[i] - A[i - 1];
                }
            }
            count += f[i][0];
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};
        System.out.println(new Solution().numberOfArithmeticSlices(A));
    }
}

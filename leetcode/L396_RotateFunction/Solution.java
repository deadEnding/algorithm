package leetcode.L396_RotateFunction;

/**
 * @author: deadend
 * @date: 10:32 AM 12/20/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int maxRotateFunction(int[] A) {
        final int n = A.length;
        if (n == 0) {
            return 0;
        }

        int psum = 0;
        int f = 0;
        for (int i = 0; i < n; i++) {
            psum += A[i];
            f += i * A[i];
        }

        int max = f;
        for (int r = 1; r < n; r++) {
            f = f + psum - n * A[n - r];
            max = Math.max(max, f);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A = {4,3,2,6};
        System.out.println(new Solution().maxRotateFunction(A));
    }
}

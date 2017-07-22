package leetcode.L279_PerfectSquares;

/**
 * @author: deadend
 * @date: 8:00 PM 2/28/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int numSquares(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            f[i] = i;
            for (int j = 1; j * j <= i; j++) {
                f[i] = Math.min(f[i], f[i - j * j] + 1);
            }
        }
        return f[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(1));
    }
}

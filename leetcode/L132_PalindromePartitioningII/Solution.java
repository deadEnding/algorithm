package leetcode.L132_PalindromePartitioningII;

/**
 * @author: deadend
 * @date: 9:50 AM 12/6/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int minCut(String s) {
        final int n = s.length();

        boolean[][] isPali = new boolean[n][n];
        int[] min = new int[n + 1];
        min[n] = -1;
        for (int i = n - 1; i >= 0; i--) {
            min[i] = n - 1 - i;
            for (int j = i; j < n; j++) {
                isPali[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 1 || isPali[i + 1][j - 1]);
                if (isPali[i][j]) {
                    min[i] = Math.min(min[i], min[j + 1] + 1);
                }
            }
        }
        return min[0];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minCut("bb"));
    }
}

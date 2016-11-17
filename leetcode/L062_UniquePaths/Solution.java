package leetcode.L062_UniquePaths;

/**
 * @author: deadend
 * @date: 8:33 PM 11/17/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int uniquePaths(int m, int n) {
        int[] row = new int[n];
        row[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                row[j] += row[j - 1];
            }
        }
        return row[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(2,3));
    }
}

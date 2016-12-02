package leetcode.L096_UniqueBinarySearchTrees;

/**
 * @author: deadend
 * @date: 9:16 PM 12/2/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numTrees(0));
    }
}

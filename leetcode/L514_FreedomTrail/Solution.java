package leetcode.L514_FreedomTrail;

/**
 * @author: deadend
 * @date: 7:57 PM 28/03/2017
 */


public class Solution {
    public int findRotateSteps(String ring, String key) {
        final int n = ring.length(), m = key.length();

        int[][] dp = new int[m + 1][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (key.charAt(i) == ring.charAt(k)) {
                        int dist = Math.abs(j - k);
                        dp[i][j] = Math.min(dp[i][j], Math.min(dist, n - dist) + dp[i + 1][k]);
                    }
                }
            }
        }
        return dp[0][0] + m;
    }

    public static void main(String[] args) {
        String ring = "godding";
        String key = "gdo";
        System.out.println(new Solution().findRotateSteps(ring, key));
    }
}

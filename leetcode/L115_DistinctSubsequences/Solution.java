package leetcode.again.L115_DistinctSubsequences;

/**
 * @author: deadend
 * @date: 4:41 PM 3/4/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int numDistinct(String s, String t) {
        final int m = s.length();
        final int n = t.length();

        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = n; j >= 1; j--) {
                dp[j] += (s.charAt(i - 1) == t.charAt(j - 1) ? dp[j - 1] : 0);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String s = "tttt";
        String t = "tt";
        System.out.println(new Solution().numDistinct(s, t));
    }
}

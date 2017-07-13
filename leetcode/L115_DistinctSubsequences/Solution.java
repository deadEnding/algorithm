package leetcode.L115_DistinctSubsequences;

/**
 * @author: deadend
 * @date: 5:P10 PM 12/4/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int numDistinct(String s, String t) {
        int m = t.length();
        int n = s.length();
        if (m > n) {
            return 0;
        }

        int[] dp = new int[m + 1];
        dp[0] = 1;

        for (int j = 0; j < n; j++) {
            for (int i = m - 1; i >= 0; i--) {
                dp[i + 1] += (t.charAt(i) == s.charAt(j) ? dp[i] : 0);
            }
        }

        return dp[m];
    }

    public static void main(String[] args) {
        String s = "ddd";
        String t = "dd";
        System.out.println(new Solution().numDistinct(s, t));
    }
}

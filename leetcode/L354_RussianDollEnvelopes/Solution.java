package leetcode.L354_RussianDollEnvelopes;

import java.util.Arrays;

/**
 * @author: deadend
 * @date: 4:38 PM 2/17/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        final int n = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
        int max = 0;
        int[] dp = new int[n];
        for (int[] e : envelopes) {
            int i = Arrays.binarySearch(dp, 0, max, e[1]);
            i = i >= 0 ? i : -(i + 1);
            dp[i] = e[1];
            if (i == max) {
                max++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] e = {{5,4}, {6,5}, {6,7}, {2,3}};
        System.out.println(new Solution().maxEnvelopes(e));
    }
}

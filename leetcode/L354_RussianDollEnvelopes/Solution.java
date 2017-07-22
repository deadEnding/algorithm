package leetcode.L354_RussianDollEnvelopes;

import java.util.Arrays;

/**
 * @author: deadend
 * @date: 3:03 PM 3/3/17
 * @version: 1.0
 * @description:
 */



public class Solution {
    public int maxEnvelopes(int[][] envs) {
        final int n = envs.length;
        Arrays.sort(envs, (e1, e2) -> (e1[0] == e2[0] ? e2[1] - e1[1] : e1[0] - e2[0]));
        int ix = 0;
        int[] f = new int[n];
        for (int[] e : envs) {
            int i = Arrays.binarySearch(f, 0, ix, e[1]);
            i = i >= 0 ? i : -(i + 1);
            f[i] = e[1];
            if (i == ix)
                ix++;
        }
        return ix;
    }
}


class BasicSolution {
    public int maxEnvelopes(int[][] envs) {
        final int n = envs.length;
        Arrays.sort(envs, (e1, e2) -> (e1[0] == e2[0] ? e1[1] - e2[1] : e1[0] - e2[0]));
        int max = 0;
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (envs[i][0] < envs[j][0] && envs[i][1] < envs[j][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

package leetcode.again.L300_LongestIncreasingSubsequence;

import java.util.Arrays;

/**
 * @author: deadend
 * @date: 9:04 PM 2/28/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int lengthOfLIS(int[] nums) {
        final int n = nums.length;
        int[] subSeqMax = new int[n];
        int len = 0;
        for (int i = 0; i < n; i++) {
            int ix = Arrays.binarySearch(subSeqMax, 0, len, nums[i]);
            ix = ix < 0 ? -(ix + 1) : ix;
            subSeqMax[ix] = nums[i];
            len += ix == len ? 1 : 0;
        }

        return len;
    }
}


class FirstSolution {
    public int lengthOfLIS(int[] nums) {
        final int n = nums.length;
        int[] subSeqMax = new int[n];
        int ix = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(subSeqMax, 0, ix, num);
            i = i >= 0 ? i : -(i + 1);
            subSeqMax[i] = num;
            if (i == ix) {
                ix++;
            }
        }
        return ix;
    }
}

class DPSolution {
    public int lengthOfLIS(int[] nums) {
        final int n = nums.length;
        int max = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

package leetcode.L300_LongestIncreasingSubsequence;

import java.util.Arrays;

/**
 * @author: deadend
 * @date: 11:37 AM 12/12/16
 * @version: 1.0
 * @description:
 */

public class Solution {
    public int lengthOfLIS(int[] nums) {            
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }

    public static void main(String[] args) {
        int[] nums = {9, 10, 2,11};
        System.out.println(new Solution().lengthOfLIS(nums));
    }
}

class BasicSolution {
    public int lengthOfLIS(int[] nums) {
        final int n = nums.length;
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] lis = new int[n];
        int max = 1;
        for (int i = 0; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
            max = Math.max(max, lis[i]);
        }
        return max;
    }
}

package leetcode.again.L376_WiggleSubsequence;

/**
 * @author: deadend
 * @date: 3:39 PM 3/1/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int wiggleMaxLength(int[] nums) {
        final int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int f = 1, d = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1])
                f = d + 1;
            else if (nums[i] < nums[i - 1])
                d = f + 1;
        }
        return Math.max(f, d);
    }
}

class DPSolution {
    public int wiggleMaxLength(int[] nums) {
        final int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int[][] dp = new int[n][2];
        dp[0][0] = dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] < nums[i]) {
                dp[i][0] = Math.max(dp[i][0], dp[i - 1][1] + 1);
                dp[i][1] = dp[i - 1][1];
            } else if (nums[i - 1] > nums[i]) {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = Math.max(dp[i][1], dp[i - 1][0] + 1);
            } else {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1];
            }
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(new DPSolution().wiggleMaxLength(nums));
    }
}

class BadDPSolution {
    public int wiggleMaxLength(int[] nums) {
        final int n = nums.length;
        int max = 0;
        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            dp[i][0] = dp[i][1] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
                } else if (nums[j] > nums[i]) {
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                }
            }
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }
        return max;
    }
}

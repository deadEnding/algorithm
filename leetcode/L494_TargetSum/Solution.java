package leetcode.L494_TargetSum;

/**
 * @author: deadend
 * @date: 11:13 AM 2/5/17
 * @version: 1.0
 * @description:
 */

class Solution {
    public int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum < s || (s + sum) % 2 == 1 ? 0 : countSubsetSum(nums, (s + sum) / 2);
    }

    private int countSubsetSum(int[] nums, int s) {
        final int n = nums.length;
        int[][] dp = new int[2][s + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= s; j++) {
                if (j < nums[i - 1]) {
                    dp[i % 2][j] = dp[(i - 1) % 2][j];
                } else {
                    dp[i % 2][j] = dp[(i - 1) % 2][j] + dp[(i - 1) % 2][j - nums[i - 1]];
                }
            }
        }
        return dp[n % 2][s];
    }
}


class SSolution {
    public int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum < s || (s + sum) % 2 == 1 ? 0 : countSubsetSum(nums, (s + sum) / 2);
    }

    private int countSubsetSum(int[] nums, int s) {
        final int n = nums.length;
        int[][] dp = new int[n + 1][s + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= s; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][s];
    }

//    private int countSubsetSum(int[] nums, int s) {
//        int[] dp = new int[s + 1];
//
//        for (int n : nums) {
//            for (int i = s; i >= n; i--) {
//                dp[i] += dp[i - n];
//            }
//        }
//        return dp[s];
//    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int s = 3;
        System.out.println(new Solution().findTargetSumWays(nums, s));
    }
}

class OldSolution {
    private int count = 0;

    private void helper(int[] nums, int ix, int S) {
        if (ix == nums.length) {
            count += S == 0 ? 1 : 0;
            return;
        }

        helper(nums, ix + 1, S + nums[ix]);
        helper(nums, ix + 1, S - nums[ix]);
    }

    public int findTargetSumWays(int[] nums, int S) {
        helper(nums, 0, -S);
        return count;
    }
}

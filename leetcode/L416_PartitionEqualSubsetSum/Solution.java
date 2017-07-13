package leetcode.L416_PartitionEqualSubsetSum;

/**
 * @author: deadend
 * @date: 7:24 PM 12/21/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum +=  num;
        }

        if (sum % 2 == 1) {
            return false;
        }

        int c = sum / 2;
        boolean[] dp = new boolean[c + 1];
        dp[0] = true;
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = c; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[c];
    }
}

class BasicDPSolution {
    public boolean canPartition(int[] nums) {
        final int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 1) {
            return false;
        }

        int c = sum / 2;
        int[] dp = new int[c + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= c; j++) {
                if (j >= nums[i]) {
                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                } else {
                    dp[j] = dp[j];
                }
            }
        }
        return dp[c] == c;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(new BasicDPSolution().canPartition(nums));
    }
}

class TimeoutSolution {
    private boolean exist(int[] nums, int ix, int sum) {
        if (sum <= 0) {
            return sum == 0;
        }

        if (ix >= nums.length) {
            return false;
        }

        if (exist(nums, ix + 1, sum - nums[ix])) {
            return true;
        }
        return exist(nums, ix + 1, sum);
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        return exist(nums, 0, sum / 2);
    }
}

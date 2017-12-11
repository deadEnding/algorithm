package leetcode.L416_PartitionEqualSubsetSum;

/**
 * @author: deadend
 * @date: 7:26 PM 3/2/17
 * @version: 1.0
 * @description:
 */


class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 1) {
            return false;
        }

        final int n = nums.length;
        final int c = sum / 2;
        int[] dp = new int[c + 1];
        for (int i = 0; i < n; i++) {
            for (int j = c; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }

        return dp[c] == c;
    }
}

class BestSolution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 1) {
            return false;
        }

        final int n = nums.length;
        final int c = sum / 2;
        boolean[] dp = new boolean[c + 1];
        dp[0] = true;

        for (int i = 0; i < n; i++) {
            for (int j = c; j >= nums[i]; j--) {
                dp[j] |= dp[j - nums[i]];
            }
        }
        return dp[c];
    }
}

class BetterSolution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 1) {
            return false;
        }

        final int n = nums.length;
        final int c = sum / 2;
        boolean[][] dp = new boolean[2][c + 1];  // dp[i][j] 表示是否能够装满
        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= c; j++) {
                if (j < nums[i - 1]) {
                    dp[i % 2][j] = dp[(i - 1) % 2][j];
                } else {
                    dp[i % 2][j] = dp[(i - 1) % 2][j] | dp[(i - 1) % 2][j - nums[i - 1]];
                }
            }
        }

        return dp[n % 2][c];
    }
}

class BasicSolution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 1) {
            return false;
        }

        final int n = nums.length;
        final int c = sum / 2;
        boolean[][] dp = new boolean[n + 1][c + 1];
        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= c; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[n][c];
    }

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        System.out.println(new Solution().canPartition(nums));
    }
}

class OldSolution {
    public boolean canPartition(int[] nums) {
        final int n = nums.length;
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % 2 == 1)
            return false;

        int c = sum / 2;
        int[] dp = new int[c + 1];
        for (int i = 0; i < n; i++) {
            for (int j = c; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[c] == c;
    }
}

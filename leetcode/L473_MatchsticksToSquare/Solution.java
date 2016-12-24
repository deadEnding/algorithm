package leetcode.L473_MatchsticksToSquare;

/**
 * @author: deadend
 * @date: 7:33 PM 12/24/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public boolean makesquare(int[] nums) {
        if (nums.length < 4) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 4 != 0) {
            return false;
        }

        return dfs(0, nums, new int[4], sum / 4);
    }

    private boolean dfs(int ix, int[] nums, int[] sum, int target) {
        if (ix == nums.length) {
            return sum[0] == target && sum[1] == target && sum[2] == target;
        }

        for (int i = 0; i < 4; i++) {
            if (sum[i] + nums[ix] <= target) {
                sum[i] += nums[ix];
                if (dfs(ix + 1, nums, sum, target)) {
                    return true;
                }
                sum[i] -= nums[ix];
            }
        }
        return false;
    }
}

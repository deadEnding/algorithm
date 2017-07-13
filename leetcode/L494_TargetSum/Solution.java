package leetcode.L494_TargetSum;

/**
 * @author: deadend
 * @date: 11:13 AM 2/5/17
 * @version: 1.0
 * @description:
 */


public class Solution {
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

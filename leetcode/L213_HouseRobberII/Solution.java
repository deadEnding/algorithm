package leetcode.L213_HouseRobberII;

/**
 * @author: deadend
 * @date: 1:52 PM 12/9/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int rob(int[] nums) {
        final int n = nums.length;
        if (n <= 1) {
            return n == 0 ? 0 : nums[0];
        }
        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }

    private int rob(int[] nums, int s, int e) {
        int curr = 0;
        for (int i = s, prev = 0; i <= e; i++) {
            int tmp = curr;
            curr = Math.max(curr, prev + nums[i]);
            prev = tmp;
        }
        return curr;
    }
}

package leetcode.L209_MinimumSizeSubarraySum;

/**
 * @author: deadend
 * @date: 9:21 PM 11/22/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0, sum = 0, ix = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                min = Math.min(min, i - ix + 1);
                sum -= nums[ix++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1};
        System.out.println(new Solution().minSubArrayLen(7, nums));
    }
}

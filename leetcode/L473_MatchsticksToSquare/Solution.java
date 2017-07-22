package leetcode.L473_MatchsticksToSquare;

/**
 * @author: deadend
 * @date: 2:12 PM 3/2/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    private boolean dfs(int ix, int[] nums, int[] sum, int target) {
        if (ix == nums.length)
            return true;

        for (int i = 0; i < 4; i++) {
            if (sum[i] + nums[ix] <= target) {
                sum[i] += nums[ix];
                if (dfs(ix + 1, nums, sum, target))
                    return true;
                sum[i] -= nums[ix];
            }
        }
        return false;
    }

    public boolean makesquare(int[] nums) {
        if (nums.length < 4) {
            return false;
        }

        int sum = 0;
        for (int num : nums)
            sum += num;
        return sum % 4 == 0 && dfs(0, nums, new int[4], sum / 4);
    }

    public static void main(String[] args) {
        int[] nums = {12,12,12,16,20,24,28,32,36,40,44,48,52,56,60};
        System.out.println(new Solution().makesquare(nums));
    }
}

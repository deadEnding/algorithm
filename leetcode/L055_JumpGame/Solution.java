package leetcode.L055_JumpGame;


public class Solution {
    public boolean canJump(int[] nums) {
        final int n = nums.length;
        for (int i = 0, max = 0; i <= max; i++) {
            max = Math.max(max, i + nums[i]);
            if (max >= n - 1) {
                return true;
            }
        }
        return false;
    }
}

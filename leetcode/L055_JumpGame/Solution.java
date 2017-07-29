package leetcode.L055_JumpGame;



public class Solution {
    public boolean canJump(int[] nums) {
        for (int l = 0, r = 0; l <= r; l++) {
            r = Math.max(r, l + nums[l]);
            if (r >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }
}


class OldSolution {
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

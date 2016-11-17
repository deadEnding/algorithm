package leetcode.L055_JumpGame;

/**
 * @author: deadend
 * @date: 8:44 AM 11/17/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public boolean canJump(int[] nums) {
        int start = 0, end = 1;
        while (start < end && end < nums.length) {
            end = Math.max(end, start + nums[start] + 1);
            start++;
        }
        return end >= nums.length;
    }

    public static void main(String[] args) {
        int[] nums = {3};
        System.out.println(new Solution().canJump(nums));
    }
}

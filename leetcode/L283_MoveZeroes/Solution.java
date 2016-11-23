package leetcode.L283_MoveZeroes;

/**
 * @author: deadend
 * @date: 10:17 AM 11/23/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public void moveZeroes(int[] nums) {
        int ix = 0;
        boolean moved = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[ix++] = nums[i];
                moved = true;
            }
        }

        while (moved && ix < nums.length) {
            nums[ix++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1};
        new Solution().moveZeroes(nums);
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }
}

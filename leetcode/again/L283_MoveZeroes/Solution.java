package leetcode.again.L283_MoveZeroes;

/**
 * @author: deadend
 * @date: 3:17 PM 3/18/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public void moveZeroes(int[] nums) {
        int ix = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                while (ix < i && nums[ix] != 0) {
                    ix++;
                }
                if (ix < i) {
                    nums[ix] = nums[i];
                    nums[i] = 0;
                }
            }
        }
    }
}

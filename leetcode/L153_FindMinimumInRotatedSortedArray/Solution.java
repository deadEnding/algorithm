package leetcode.L153_FindMinimumInRotatedSortedArray;

/**
 * @author: deadend
 * @date: 3:18 PM 2/28/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] < nums[r]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return nums[l];
    }
}

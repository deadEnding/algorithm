package leetcode.L154_FindMinimumInRotatedSortedArrayII;

/**
 * @author: deadend
 * @date: 3:24 PM 2/28/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else if (nums[m] < nums[r]) {
                r = m;
            } else {
                if (nums[l] < nums[m]) {
                    return nums[l];
                } else if (nums[l] > nums[m]) {
                    r = m;
                } else {
                    l++;
                }
            }
        }
        return nums[l];
    }
}

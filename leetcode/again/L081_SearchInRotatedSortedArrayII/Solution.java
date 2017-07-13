package leetcode.again.L081_SearchInRotatedSortedArrayII;

/**
 * @author: deadend
 * @date: 11:17 AM 2/28/17
 * @version: 1.0
 * @description:
 */

public class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return true;
            } else if (nums[m] < nums[r]) {
                if (target > nums[m] && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else if (nums[m] > nums[r]) {
                if (target >= nums[l] && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (nums[l] == nums[m]) {
                    l++;
                } else {
                    r = m - 1;
                }
            }
        }
        return false;
    }
}

class RegularSolution {
    public boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return true;
            } else if (nums[l] < nums[m]) {
                if (target >= nums[l] && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else if (nums[l] > nums[m]) {
                if (target > nums[m] && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                if (nums[m] < nums[r]) {
                    l = m + 1;
                } else {
                    l++;
                }
            }
        }
        return false;
    }
}

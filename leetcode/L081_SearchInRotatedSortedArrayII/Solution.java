package leetcode.L081_SearchInRotatedSortedArrayII;

/**
 * @author: deadend
 * @date: 8:45 PM 11/20/16
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
                if (nums[m] < target && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else if (nums[m] > nums[r]) {
                if (nums[l] <= target && target < nums[m]) {
                    r  = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                r--;
            }
        }
        return false;
    }
}

















class FirstSolution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }

            if (nums[mid] > nums[left]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < nums[right]){
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (nums[left] == nums[mid]) {
                left++;
            } else {  // nums[mid] == nums[right]
                right--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,3};
        System.out.println(new Solution().search(nums, 3));
    }
}

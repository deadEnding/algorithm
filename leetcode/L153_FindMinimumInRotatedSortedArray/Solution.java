package leetcode.L153_FindMinimumInRotatedSortedArray;

/**
 * @author: deadend
 * @date: 3:03 PM 11/22/16
 * @version: 1.0
 * @description:
 */

public class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(new Solution().findMin(nums));
    }
}

class Solution1 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[left] <= nums[mid] && nums[mid] <= nums[right]) {
                return nums[left];
            } else if (nums[left] <= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }
}

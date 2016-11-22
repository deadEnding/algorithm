package leetcode.L162_FindPeakElement;

/**
 * @author: deadend
 * @date: 4:37 PM 11/22/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int lv = mid - 1 >= 0 ? nums[mid - 1] : Integer.MIN_VALUE;
            int rv = mid + 1 < nums.length ? nums[mid + 1] : Integer.MIN_VALUE;
            if (nums[mid] >= lv && nums[mid] >= rv) {
                return mid;
            } else if (nums[mid] < lv) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {Integer.MIN_VALUE};
        System.out.println(new Solution().findPeakElement(nums));
    }
}
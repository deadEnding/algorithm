package leetcode.L154_FindMinimumInRotatedSortedArrayII;

/**
 * @author: deadend
 * @date: 3:21 PM 11/22/16
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
            } else if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r--;
            }
        }
        return nums[l];
    }
}


class FirstSolution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]){
                right = mid;
            } else {
                right--;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {3,3,1,3};
        System.out.println(new Solution().findMin(nums));
    }
}

package leetcode.L034_SearchForARange;

/**
 * @author: deadend
 * @date: 2:02 PM 11/P10/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (nums[left] == target && target == nums[right]) {
                return new int[]{left, right};
            }

            int mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                if (nums[left] != target) {
                    left++;
                }
                if (nums[right] != target) {
                    right--;
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {8, 8};
        int[] result = new Solution().searchRange(nums, 7);
        System.out.println(result[0] + " " + result[1]);
    }
}

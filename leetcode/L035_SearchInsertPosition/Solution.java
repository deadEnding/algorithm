package leetcode.L035_SearchInsertPosition;

/**
 * @author: deadend
 * @date: 2:40 PM 11/10/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        // [left, right)范围，去掉 < target 的元素，保留 >= target 的元素
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {0,1};
        System.out.println(new Solution2().searchInsert(nums, 2));
    }
}

class Solution2 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}

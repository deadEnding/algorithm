package leetcode.L035_SearchInsertPosition;

/**
 * @author: deadend
 * @date: 8:50 AM 2/28/17
 * @version: 1.0
 * @description:
 */



public class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2,3,3};
        System.out.println(new Solution().searchInsert(nums, 1));
    }
}


class OldSolution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}

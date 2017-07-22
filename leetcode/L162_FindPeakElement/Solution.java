package leetcode.again.L162_FindPeakElement;

/**
 * @author: deadend
 * @date: 3:46 PM 3/17/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int findPeakElement(int[] nums) {
        final int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            int left = m == 0 ? Integer.MIN_VALUE : nums[m - 1];
            int right = m == n - 1 ? Integer.MIN_VALUE : nums[m + 1];
            if (left < nums[m] && nums[m] > right) {
                return m;
            } else if (left > nums[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(new Solution().findPeakElement(nums));
    }
}

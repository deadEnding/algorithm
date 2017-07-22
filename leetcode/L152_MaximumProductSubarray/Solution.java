package leetcode.again.L152_MaximumProductSubarray;

/**
 * @author: deadend
 * @date: 3:02 PM 2/28/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int subMax = 1, subMin = 1;
        for (int num : nums) {
            int tMax = subMax * num;
            int tMin = subMin * num;
            subMax = Math.max(num, Math.max(tMax, tMin));
            subMin = Math.min(num, Math.min(tMax, tMin));
            max = Math.max(max, subMax);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,-2,-3};
        System.out.println(new Solution().maxProduct(nums));
    }
}

package leetcode.L152_MaximumProductSubarray;

/**
 * @author: deadend
 * @date: 2:00 PM 11/22/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int maxProduct(int[] nums) {
        int subMin, subMax, result;
        subMin = subMax = result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tmpMin = subMin * nums[i];
            int tmpMax = subMax * nums[i];
            subMin = Math.min(Math.min(tmpMin, tmpMax), nums[i]);
            subMax = Math.max(Math.max(tmpMin, tmpMax), nums[i]);
            result = Math.max(result, subMax);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 3, -4};
        System.out.println(new Solution().maxProduct(nums));
    }
}
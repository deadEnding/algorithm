package leetcode.L330_PatchingArray;

/**
 * @author: deadend
 * @date: 12:18 PM 2/17/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int minPatches(int[] nums, int n) {
        int count = 0;
        int ix = 0;
        long miss = 1;
        while (miss <= n) {
            if (ix >= nums.length || nums[ix] > miss) {
                miss += miss;
                count++;
            } else {
                miss += nums[ix++];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 31, 33};
        System.out.println(new Solution().minPatches(nums, Integer.MAX_VALUE));
    }
}

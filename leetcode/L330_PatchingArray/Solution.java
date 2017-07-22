package leetcode.L330_PatchingArray;

/**
 * @author: deadend
 * @date: 1:16 PM 3/3/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int count = 0;
        int ix = 0;
        while (miss <= n) {
            if (ix >= nums.length || nums[ix] > miss) {
                count++;
                miss *= 2;
            } else {
                miss += nums[ix++];
            }
        }
        return count;
    }
}

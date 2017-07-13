package leetcode.again.L280_WiggleSort;

import java.util.Arrays;

/**
 * @author: deadend
 * @date: 8:22 PM 3/P10/17
 * @version: 1.0
 * @description:
 */


public class Solution {

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }

    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if ((i % 2 == 1 && nums[i - 1] > nums[i]) || (i % 2 == 0 && nums[i - 1] < nums[i])) {
                swap(nums, i - 1, i);
            }
        }
    }
}

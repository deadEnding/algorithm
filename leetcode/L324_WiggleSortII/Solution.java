package leetcode.L324_WiggleSortII;

import java.util.Arrays;

/**
 * @author: deadend
 * @date: P10:18 PM 12/15/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public void wiggleSort(int[] nums) {
        final int n = nums.length;

        Arrays.sort(nums);
        int[] arr = Arrays.copyOf(nums, n);
        int i, ix;

        // 从右向左偶数索引放小数
        for (i = 0, ix = (n % 2 == 1 ? n - 1 : n - 2); ix >= 0; i++, ix -= 2) {
            nums[ix] = arr[i];
        }

        // 从右向左奇数索引放大数
        for (ix = (n % 2 == 0 ? n - 1 : n - 2); ix >= 0; i++, ix -= 2) {
            nums[ix] = arr[i];
        }
    }
}

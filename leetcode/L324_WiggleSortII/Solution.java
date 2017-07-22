package leetcode.L324_WiggleSortII;

import java.util.Arrays;

/**
 * @author: deadend
 * @date: 9:08 PM 3/P10/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public void wiggleSort(int[] nums) {
        final int n = nums.length;

        Arrays.sort(nums);
        int[] arr = Arrays.copyOf(nums, n);

        int ix = 0;

        // 从右向左偶数位置放前一半小数
        for (int i = (n % 2 == 1 ? n - 1 : n - 2); i >= 0; i -= 2) {
            nums[i] = arr[ix++];
        }

        // 从右向左奇数位置放后一半大数
        for (int i = (n % 2 == 1 ? n - 2 : n - 1); i >= 1; i -= 2) {
            nums[i] = arr[ix++];
        }
    }
}

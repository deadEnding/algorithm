package leetcode.again.L031_NextPermutation;

import java.util.Arrays;

/**
 * @author: deadend
 * @date: P10:02 AM 3/3/17
 * @version: 1.0
 * @description:
 */


public class Solution {

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    public void nextPermutation(int[] nums) {
        final int n = nums.length;
        int i;
        for (i = n - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i])
                break;
        }

        reverse(nums, i, n - 1);

        if (i != 0) {
            for (int k = i; k < n; k++) {
                if (nums[k] > nums[i - 1]) {
                    swap(nums, k, i - 1);
                    break;
                }
            }
        }
    }
}

class FirstSolution {
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private void reverse(int[] nums, int ix) {
        for (int i = ix, j = nums.length - 1; i < j; i++, j--) {
            swap(nums, i, j);
        }
    }

    public void nextPermutation(int[] nums) {
        final int n = nums.length;

        int ix = n - 1;
        while (ix >= 0 && (ix == n - 1 || nums[ix] >= nums[ix + 1])) {
            ix--;
        }

        reverse(nums, ix + 1);
        if (ix >= 0) {
            for (int i = ix + 1; i < n; i++) {
                if (nums[i] > nums[ix]) {
                    swap(nums, i, ix);
                    break;
                }
            }

        }
    }

    public static void main(String[] args) {
        int[] nums = {};
        new Solution().nextPermutation(nums);
        for (int n : nums)
            System.out.print(n + " ");
    }
}

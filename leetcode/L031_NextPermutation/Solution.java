package leetcode.L031_NextPermutation;

import java.util.Arrays;

/**
 * @author: deadend
 * @date: 11:17 AM 11/10/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public void nextPermutation(int[] nums) {
        final int n = nums.length;
        if (n <= 1) {
            return;
        }

        if (nums[n - 2] < nums[n - 1]) {
            swap(nums, n - 2, n - 1);
            return;
        }

        int m = n - 2;
        while (m >= 0 && nums[m] >= nums[m + 1]) {
            m--;
        }

        if (m != -1) {
            int ix = search(nums, m + 1, n - 1, nums[m]);
            swap(nums, ix, m);
        }
        reverse(nums, m + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private int search(int[] nums, int i, int j, int val) {
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] <= val) {
                j = mid - 1;
            } else {
                if (nums[mid + 1] <= val)
                    return mid;
                else
                    i = mid + 1;
            }
        }
        return i;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,5,5,2};
        new Solution().nextPermutation(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}

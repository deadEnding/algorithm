package leetcode.L189_RotateArray;

/**
 * @author: deadend
 * @date: 5:14 PM 11/22/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    private void swapList(int[] nums, int i, int j) {
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        swapList(nums, 0, nums.length - 1);
        swapList(nums, 0, k - 1);
        swapList(nums, k, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5};
        new Solution().rotate(nums, 5);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}

class Solution1 {
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void rotate(int[] nums, int k) {
        final int n = nums.length;
        k %= n;

        for (int i = 0; i < n / 2; i++) {
            swap(nums, i, n - 1 - i);
        }

        for (int i = 0; i < k / 2; i++) {
            swap(nums, i, k - 1 - i);
        }

        for (int i = k; i < k + (n - k) / 2; i++) {
            swap(nums, i, n + k - i - 1);
        }
    }
}

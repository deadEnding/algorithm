package leetcode.L321_CreateMaximumNumber;

/**
 * @author: deadend
 * @date: P10:31 PM 1/8/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    private int[] maxNumber(int[] nums, int k) {
        final int n = nums.length;
        int[] arr = new int[k];
        for (int i = 0, j = 0; i < n; i++) {
            while (n - i + j > k && j > 0 && arr[j - 1] < nums[i]) {
                j--;
            }
            if (j < k) {
                arr[j++] = nums[i];
            }
        }
        return arr;
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        for (int ix = 0, i = 0, j = 0; ix < nums.length; ix++) {
            nums[ix] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return nums;
    }

    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }

        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        final int n1 = nums1.length, n2 = nums2.length;
        int[] max = new int[k];
        for (int i = Math.max(0, k - n2); i <= n1 && i <= k; i++) {
            int[] nums = merge(maxNumber(nums1, i), maxNumber(nums2, k - i));
            if (greater(nums, 0, max, 0)) {
                max = nums;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int k = 5;
        int[] nums1 = {6, 7};
        int[] nums2 = {6, 0, 4};
        int[] nums = new Solution().maxNumber(nums1, nums2, k);
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }
}

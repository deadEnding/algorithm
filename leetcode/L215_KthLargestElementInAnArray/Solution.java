package leetcode.L215_KthLargestElementInAnArray;

/**
 * @author: deadend
 * @date: 2:55 PM 12/9/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    private int partition(int[] nums, int s, int e) {
        int pivot = nums[s];
        int i = s;
        int j = e;
        while (i < j) {
            while (i < j && nums[j] < pivot) {
                j--;
            }
            if (i < j) {
                nums[i++] = nums[j];
            }

            while (i < j && nums[i] >= pivot) {
                i++;
            }
            if (i < j) {
                nums[j--] = nums[i];
            }
        }

        nums[i] = pivot;
        return i;
    }

    private int findKthLargest(int[] nums, int s, int e, int k) {
        int ix = partition(nums, s, e);
        int len = ix - s + 1;
        if (len == k) {
            return nums[ix];
        } else if (len < k) {
            return findKthLargest(nums, ix + 1, e, k - len);
        } else {
            return findKthLargest(nums, s, ix - 1, k);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k);
    }

    public static void main(String[] args) {
        int[] nums = {1,5,3,2,5,6};
        System.out.println(new Solution().findKthLargest(nums, 6));
    }
}

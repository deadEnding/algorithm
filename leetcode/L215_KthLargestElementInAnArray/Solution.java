package leetcode.L215_KthLargestElementInAnArray;

/**
 * @author: deadend
 * @date: 3:34 PM 2/28/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    private int partition(int[] nums, int s, int e) {
        int pivot = nums[s];
        while (s < e) {
            while (s < e && nums[e] < pivot) {
                e--;
            }
            nums[s] = nums[e];

            while (s < e && nums[s] >= pivot) {
                s++;
            }
            nums[e] = nums[s];
        }
        nums[s] = pivot;
        return s;
    }

    private int findKthLargest(int[] nums, int s, int e, int k) {
        int ix = partition(nums, s, e);
        if (ix == k) {
            return nums[ix];
        } else if (ix < k) {
            return findKthLargest(nums, ix + 1, e, k);
        } else {
            return findKthLargest(nums, s, ix - 1, k);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k - 1);
    }
}


class FirstSolution {
    private int partition(int[] nums, int s, int e) {
        int pivot = nums[s];
        while (s < e) {
            while (s < e && nums[e] < pivot) {
                e--;
            }
            if (s < e) {
                nums[s] = nums[e];
            }

            while (s < e && nums[s] >= pivot) {
                s++;
            }
            if (s < e) {
                nums[e] = nums[s];
            }
        }

        nums[s] = pivot;
        return s;
    }

    private int findKthLargest(int[] nums, int s, int e, int k) {
        int ix = partition(nums, s, e);
        if (ix == k) {
            return nums[ix];
        } else if (ix > k) {
            return findKthLargest(nums, s, ix - 1, k);
        } else {
            return findKthLargest(nums, ix + 1, e, k);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k - 1);
    }

    public static void main(String[] args) {
        int[] nums = {3};
        System.out.println(new Solution().findKthLargest(nums, 1));
    }
}

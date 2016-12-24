package leetcode.L462_MinimumMovesToEqualArrayElementsII;

/**
 * @author: deadend
 * @date: 3:08 PM 12/24/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    private int findKth(int[] nums, int s, int e, int kth) {
        if (s == e) {
            return nums[s];
        }

        int pivot = nums[s];
        int i = s, j = e;
        while (i < j) {
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            if (i < j) {
                nums[i++] = nums[j];                
            }

            while (i < j && nums[i] < pivot) {
                i++;
            }
            if (i < j) {
                nums[j--] = nums[i];
            }
        }
        nums[i] = pivot;
        if (i + 1 == kth) {
            return nums[i];
        } else if (i + 1 > kth) {
            return findKth(nums, s, i - 1, kth);
        } else {
            return findKth(nums, i + 1, e, kth);
        }
    }

    public int minMoves2(int[] nums) {
        final int n = nums.length;
        int mid = findKth(nums, 0, n - 1, (n + 1) / 2);
        int sum = 0;
        for (int num : nums) {
            sum += Math.abs(num - mid);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {4};
        System.out.println(new Solution().minMoves2(nums));
    }
}

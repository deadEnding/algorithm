package leetcode.L287_FindTheDuplicateNumber;

/**
 * @author: deadend
 * @date: 11:14 AM 11/23/16
 * @version: 1.0
 * @description:
 */



public class Solution {
    // 可看做链表，寻找环的起点
    public int findDuplicate(int[] nums) {
        int oneStep = nums.length;
        int twoStep = nums.length;

        do {
            oneStep = nums[oneStep - 1];
            twoStep = nums[nums[twoStep - 1] - 1];
        } while (oneStep != twoStep);

        twoStep = nums.length;
        while (oneStep != twoStep) {
            oneStep = nums[oneStep - 1];
            twoStep = nums[twoStep - 1];
        }
        return oneStep;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3};
        System.out.println(new Solution().findDuplicate(nums));
    }
}

class BinarySearchSolution {
    public int findDuplicate(int[] nums) {
        final int n = nums.length;
        int left = 1;
        int right = n - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int i = 0; i < n; i++) {
                count += nums[i] <= mid ? 1 : 0;
            }

            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
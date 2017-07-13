package leetcode.L041_FirstMissingPositive;

/**
 * @author: deadend
 * @date: 4:52 PM 11/P10/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1) {
                if (nums[i] <= 0 || nums[i] > nums.length || nums[nums[i] - 1] == nums[i]) {
                    break;
                }
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        System.out.println(new Solution().firstMissingPositive(nums));
    }
}


class Solution2 {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            helper(nums, i);
        }

        for (int  i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private void helper(int[] nums, int i) {
        final int tmp = nums[i];
        nums[i] = 0;   // 避免循环占用
        if (tmp <= 0 || tmp > nums.length || nums[tmp - 1] == tmp) {
            return;
        }

        if (nums[tmp - 1] > 0) {
            helper(nums, tmp - 1);
        }
        nums[tmp - 1] = tmp;
    }
}

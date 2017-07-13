package leetcode.L080_RemoveDuplicatesFromSortedArrayII;

/**
 * @author: deadend
 * @date: P10:22 AM 11/18/16
 * @version: 1.0
 * @description:
 */

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int ix = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[ix - 2]) {
                nums[ix++] = nums[i];
            }
        }
        return ix;
    }
}

class Solution2 {
    public int removeDuplicates(int[] nums) {
        int len = 0;
        for (int i = 0; i < nums.length; ) {
            nums[len++] = nums[i++];
            while (i < nums.length && len >= 2 && nums[i] == nums[len - 1] && nums[i] == nums[len - 2]) {
                i++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(new Solution().removeDuplicates(nums));
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}

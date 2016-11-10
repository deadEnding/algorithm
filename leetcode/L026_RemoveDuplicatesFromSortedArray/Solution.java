package leetcode.L026_RemoveDuplicatesFromSortedArray;

/**
 * @author: deadend
 * @date: 9:55 AM 11/10/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int removeDuplicates(int[] nums) {
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 >= 0 && nums[i] == nums[i - 1])
                continue;
            nums[len++] = nums[i];
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        System.out.println(new Solution().removeDuplicates(nums));
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}

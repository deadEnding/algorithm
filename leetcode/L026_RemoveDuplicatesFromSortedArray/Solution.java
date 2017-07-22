package leetcode.L026_RemoveDuplicatesFromSortedArray;


public class Solution {
    public int removeDuplicates(int[] nums) {
        final int n = nums.length;
        int len = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                nums[len++] = nums[i];
            }
        }
        return len;
    }
}

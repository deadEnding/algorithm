package leetcode.L088_MergeSortedArray;

/**
 * @author: deadend
 * @date: 2:27 PM 11/21/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        for (int ix = m + n - 1; ix >= 0; ix--) {
            if (i >= 0 && j >= 0) {
                nums1[ix] = nums1[i] >= nums2[j] ? nums1[i--] : nums2[j--];
            } else if (i >= 0) {
                nums1[ix] = nums1[i--];
            } else {
                nums1[ix] = nums2[j--];
            }
        }
    }
}
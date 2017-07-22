package leetcode.L088_MergeSortedArray;


public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        final int len = m + n;
        for (int k = len - 1, i = m - 1, j = n - 1; k >= 0; k--) {
            long a = i >= 0 ? nums1[i] : Integer.MIN_VALUE - 1L;
            long b = j >= 0 ? nums2[j] : Integer.MIN_VALUE - 1L;
            nums1[k] = a > b ? nums1[i--] : nums2[j--];

            if (j < 0)
                break;
        }
    }
}

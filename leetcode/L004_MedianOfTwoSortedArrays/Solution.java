package leetcode.L004_MedianOfTwoSortedArrays;

/**
 * @author: deadend
 * @date: 8:40 PM 11/9/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int n1 = nums1.length;
        final int n2 = nums2.length;
        if ((n1 + n2) % 2 == 1) {
            return findMedianSortedArrays(nums1, 0, n1, nums2, 0, n2, (n1 + n2 + 1) / 2);
        } else {
            double first = findMedianSortedArrays(nums1, 0, n1, nums2, 0, n2, (n1 + n2) / 2);
            double second =  findMedianSortedArrays(nums1, 0, n1, nums2, 0, n2, (n1 + n2) / 2 + 1);
            return (first + second) / 2;
        }
    }


    private double findMedianSortedArrays(int[] nums1, int i1, int n1, int[] nums2, int i2, int n2, int k) {
        if (n1 > n2) {
            return findMedianSortedArrays(nums2, i2, n2, nums1, i1, n1, k);
        }

        if (n1 == 0) {
            return nums2[k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[i1], nums2[i2]);
        }

        int p1 = Math.min(k / 2, n1);
        int p2 = k - p1;

        if (nums1[i1 + p1 - 1] < nums2[i2 + p2 - 1]) {
            return findMedianSortedArrays(nums1, i1 + p1, n1 - p1, nums2, i2, n2, k - p1);
        } else if (nums1[i1 + p1 - 1] > nums2[i2 + p2 - 1]) {
            return findMedianSortedArrays(nums1, i1, n1, nums2, i2 + p2, n2 - p2, k - p2);
        } else {
            return nums1[i1 + p1 - 1];
        }
    }

    public static void main(String[] args) {
        int[] num1 = {1};
        int[] nums2 = {1};
        System.out.println(new Solution().findMedianSortedArrays(num1, nums2));
    }
}

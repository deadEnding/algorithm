package leetcode.again.L004_MedianOfTwoSortedArrays;

/**
 * @author: deadend
 * @date: 7:15 PM 3/9/17
 * @version: 1.0
 * @description:
 */


public class Solution {

    private int find(int[] nums1, int s1, int e1, int[] nums2, int s2, int e2, int k) {
        int n1 = e1 - s1 + 1;
        int n2 = e2 - s2 + 1;

        if (n1 > n2) {
            return find(nums2, s2, e2, nums1, s1, e1, k);
        }

        if (n1 == 0) {
            return nums2[s2 + k - 1];
        }

        if (k == 1) {  // 特殊情况
            return Math.min(nums1[s1], nums2[s2]);
        }

        int c1 = Math.min(n1, k / 2);
        int c2 = k - c1;
        int x1 = s1 + c1 - 1;
        int x2 = s2 + c2 - 1;

        if (nums1[x1] < nums2[x2]) {
            return find(nums1, x1 + 1, e1, nums2, s2, e2, k - c1);
        } else if (nums1[x1] > nums2[x2]) {
            return find(nums1, s1, e1, nums2, x2 + 1, e2, k - c2);
        } else {
            return nums1[x1];
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;

        if (n % 2 == 1) {
            return find(nums1, 0, n1 - 1, nums2, 0, n2 - 1, n / 2 + 1);
        }

        return (find(nums1, 0, n1 - 1, nums2, 0, n2 - 1, n / 2) +
            find(nums1, 0, n1 - 1, nums2, 0, n2 - 1, n / 2 + 1)) / 2.0;
    }

    public static void main(String[] args) {
        int[] n1 = {1,3};
        int[] n2 = {2,3};
        System.out.println(new Solution().findMedianSortedArrays(n1, n2));
    }
}

class OldSolution {
    private int findKth(int[] nums1, int i1, int[] nums2, int i2, int k) {
        if (nums1.length - i1 > nums2.length - i2) {   // 关键，因为c1取较小值只保证了nums1没有越界
            return findKth(nums2, i2, nums1, i1, k);
        }

        if (i1 == nums1.length) {
            return nums2[i2 + k - 1];
        }

//        if (i2 == nums2.length) {   // 不可能
//            return nums1[i1 + k - 1];
//        }

        if (k == 1) {
            return Math.min(nums1[i1], nums2[i2]);
        }

        int c1 = Math.min(k / 2, nums1.length - i1);
        int c2 = k - c1;
        int m1 = i1 + c1 - 1;
        int m2 = i2 + c2 - 1;
        if (nums1[m1] < nums2[m2]) {
            return findKth(nums1, m1 + 1, nums2, i2, k - c1);
        } else if (nums1[m1] > nums2[m2]) {
            return findKth(nums1, i1, nums2, m2 + 1, k - c2);
        } else {
            return nums1[m1];
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int c = nums1.length + nums2.length;
        if (c % 2 == 1) {
            return findKth(nums1, 0, nums2, 0, c / 2 + 1);
        } else {
            double n1 = findKth(nums1, 0, nums2, 0, c / 2);
            double n2 = findKth(nums1, 0, nums2, 0, c / 2 + 1);
            return (n1 + n2) / 2;
        }
    }
}

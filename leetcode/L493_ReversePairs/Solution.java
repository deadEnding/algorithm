package leetcode.L493_ReversePairs;

import java.util.Arrays;

/**
 * @author: deadend
 * @date: 1:09 PM 2/12/17
 * @version: 1.0
 * @description:
 */

//public class RandomOneHundred {
//
//    private int merge(int[] nums, int s, int m, int e) {
//        final int n = e - s + 1;
//        int[] tmp = new int[n];
//        int count = 0;
//        for (int ix = 0, i = s, j = m + 1; ix < n; ix++) {
//            long A = i <= m ? nums[i] : Integer.MAX_VALUE + 1L;
//            long b = j < n ? nums[j] : Integer.MAX_VALUE + 1L;
//            if (A < b) {
//                int t = nums[i] / 2 + (nums[i] % 2 == 1 ? 1 : 0);
//                int index = Arrays.binarySearch(nums, m + 1, e + 1, t);
//                count += (index >= 0 ? index : -(index + 1)) - m - 1;
//                tmp[ix] = nums[i++];
//            } else {
//                int t = 2 * nums[j];
//                int index = Arrays.binarySearch(nums, s, m + 1, t);
//                count += index >= 0 ? m - index : m + index + 2;
//                tmp[ix] = nums[j++];
//            }
//        }
//
//        for (int i = s, ix = 0; i <= e; i++) {
//            nums[i] = tmp[ix++];
//        }
//        return count;
//    }
//
//    private int reversePairs(int[] nums, int s, int e) {
//        if (s == e) {
//            return 0;
//        }
//
//        int m = s + (e - s) / 2;
//        return reversePairs(nums, s, m) + reversePairs(nums, m + 1, e) + merge(nums, s, m, e);
//    }
//
//    public int reversePairs(int[] nums) {
//        return reversePairs(nums, 0, nums.length - 1);
//    }
//}

class Solution {
    class TreeNode {
        int val, dup, leftCount;
        TreeNode left, right;
        public TreeNode(int v) {
            val = v;
            dup = 1;
            leftCount = 0;
        }
    }

    public TreeNode insert(TreeNode root, int num) {
        if (root == null) {
            root = new TreeNode(num);
        } else if (root.val == num) {
            root.dup++;
        } else if (num < root.val) {
            root.left = insert(root.left, num);
            root.leftCount++;
        } else {
            root.right = insert(root.right, num);
        }
        return root;
    }

    public int search(TreeNode root, int num) {
        if (root == null) {
            return 0;
        }

        if (root.val == num) {
            return root.leftCount;
        } else if (num < root.val) {
            return search(root.left, num);
        } else {
            return root.leftCount + root.dup + search(root.right, num);
        }
    }

    public int reversePairs(int[] nums) {
        final int n = nums.length;
        TreeNode root = null;
        int total = 0;
        for (int i = n - 1; i >= 0; i--) {
            int t = nums[i] / 2 + (nums[i] % 2 == 1 ? 1 : 0);
            total += search(root, t);
            root = insert(root, nums[i]);
        }
        return total;
    }

    public static void main(String[] args) {
        int[] nums = {2,4,3,5,1};
        System.out.println(new Solution().reversePairs(nums));
    }
}

package leetcode.L108_ConvertSortedArrayToBinarySearchTree;

/**
 * @author: deadend
 * @date: 9:18 PM 12/3/16
 * @version: 1.0
 * @description:
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    private TreeNode sortedArrayToBST(int[] nums, int s, int e) {
        if (s > e) {
            return null;
        }

        int m = s + (e - s) / 2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = sortedArrayToBST(nums, s, m - 1);
        root.right = sortedArrayToBST(nums, m + 1, e);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }
}

class OldSolution {
    private TreeNode build(int[] nums, int s, int e) {
        if (s == e) {
            return null;
        }

        int rootPos = s + (e - s) / 2;
        TreeNode root = new TreeNode(rootPos);
        root.left = build(nums, s, rootPos);
        root.right = build(nums, rootPos + 1, e);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length);
    }
}

package leetcode.L098_ValidateBinarySearchTree;

/**
 * @author: deadend
 * @date: 10:49 PM 12/2/16
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
    private boolean isValid(TreeNode root, long from, long to) {
        if (root == null) {
            return true;
        }
        return from < root.val && root.val < to && isValid(root.left, from, root.val)
                && isValid(root.right, root.val, to);
    }

    public boolean isValidBST(TreeNode root) {
        return isValid(root, Integer.MIN_VALUE - 1L, Integer.MAX_VALUE + 1L);
    }
}

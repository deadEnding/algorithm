package leetcode.L098_ValidateBinarySearchTree;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {

    private boolean validate(TreeNode root, long s, long e) {
        if (root == null) {
            return true;
        }

        return s < root.val && root.val < e &&
                validate(root.left, s, root.val) && validate(root.right, root.val, e);
    }

    public boolean isValidBST(TreeNode root) {
        return validate(root, Integer.MIN_VALUE - 1L, Integer.MAX_VALUE + 1L);
    }
}

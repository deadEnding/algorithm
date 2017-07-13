package leetcode.again.L450_DeleteNodeInABst;

/**
 * @author: deadend
 * @date: P10:03 AM 3/2/17
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
    private int findMin(TreeNode root) {
        while (root.left != null)
            root = root.left;
        return root.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        if (key == root.val) {
            if (root.left == null || root.right == null)
                return root.left == null ? root.right : root.left;

            root.val = findMin(root.right);
            root.right = deleteNode(root.right, root.val);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
}

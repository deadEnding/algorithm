package leetcode.L543_DiameterOfBinaryTree;

/**
 * @author: deadend
 * @date: 11:35 PM 02/04/2017
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    private int max;

    private int postorder(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = postorder(root.left);
        int right = postorder(root.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        postorder(root);
        return max;
    }
}

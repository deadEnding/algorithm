package leetcode.L538_ConvertBstToGreaterTree;

/**
 * @author: deadend
 * @date: 9:50 PM 01/04/2017
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    private int last = 0;

    private void reverseInorder(TreeNode root) {
        if (root == null) {
            return;
        }

        reverseInorder(root.right);
        root.val += last;
        last = root.val;
        reverseInorder(root.left);
    }

    public TreeNode convertBST(TreeNode root) {
        reverseInorder(root);
        return root;
    }
}

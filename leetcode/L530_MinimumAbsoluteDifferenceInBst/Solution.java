package leetcode.L530_MinimumAbsoluteDifferenceInBst;

/**
 * @author: deadend
 * @date: 7:09 PM 01/04/2017
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    private Integer last;
    private Integer min = Integer.MAX_VALUE;

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        if (last != null) {
            min = Math.min(min, Math.abs(last - root.val));
        }
        last = root.val;
        inorder(root.right);
    }

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return min;
    }
}

package leetcode.L124_BinaryTreeMaximumPathSum;

/**
 * @author: deadend
 * @date: 12:31 PM 12/5/16
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
    private int max = Integer.MIN_VALUE;

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lmax = Math.max(0, dfs(root.left));
        int rmax = Math.max(0, dfs(root.right));

        max = Math.max(max, lmax + rmax + root.val);
        return Math.max(lmax, rmax) + root.val;

    }

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
}

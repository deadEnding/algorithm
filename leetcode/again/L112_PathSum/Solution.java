package leetcode.again.L112_PathSum;

/**
 * @author: deadend
 * @date: 7:43 PM 3/1/17
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            return true;
        }

        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}

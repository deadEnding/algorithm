package leetcode.L129_SumRootToLeafNumbers;

/**
 * @author: deadend
 * @date: 3:51 PM 12/5/16
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
    private int sum = 0;

    private void dfs(TreeNode root, int path) {
        path = path * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += path;
            return;
        }

        if (root.left != null) {
            dfs(root.left, path);
        }

        if (root.right != null) {
            dfs(root.right, path);
        }
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root, 0);
        return sum;
    }
}

package leetcode.L236_LowestCommonAncestorOfABinaryTree;

/**
 * @author: deadend
 * @date: 9:09 PM 12/10/16
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : (right == null ? left : root);
    }
}

class BasicSolution {
    private TreeNode lca;

    private int dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return 0;
        }

        int lcount = dfs(root.left, p, q);
        if (lcount == 2) {
            return 2;
        }
        int rcount = dfs(root.right, p, q);
        if (rcount == 2) {
            return 2;
        }

        int count = lcount + rcount + ((root == p || root == q) ? 1 : 0);
        if (count == 2 && lca == null) {
            lca = root;
        }
        return count;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return lca;
    }
}

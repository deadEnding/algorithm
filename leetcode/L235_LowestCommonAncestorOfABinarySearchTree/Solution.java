package leetcode.L235_LowestCommonAncestorOfABinarySearchTree;

/**
 * @author: deadend
 * @date: 8:42 PM 12/10/16
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
        if ((p.val - root.val) * (q.val - root.val) <= 0) {
            return root;
        }
        return lowestCommonAncestor(p.val < root.val ? root.left : root.right, p, q);
    }
}

class RecusiveSolution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while ((p.val - root.val) * (q.val - root.val) > 0) {
            root = p.val < root.val ? root.left : root.right;
        }
        return root;
    }
}

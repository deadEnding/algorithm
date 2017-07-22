package leetcode.L235_LowestCommonAncestorOfABinarySearchTree;

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

        return p.val > root.val ? lowestCommonAncestor(root.right, p, q) : lowestCommonAncestor(root.left, p, q);
    }
}


class IterativeSolution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while ((p.val - root.val) * (q.val - root.val) > 0) {
            root = p.val > root.val ? root.right : root.left;
        }
        return root;
    }
}

package leetcode.again.L617_MergeTwoBinaryTrees;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class Solution {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }

        TreeNode root;
        if (t1 == null) {
            root = new TreeNode(t2.val);
            root.left = mergeTrees(null, t2.left);
            root.right = mergeTrees(null, t2.right);
        } else if (t2 == null) {
            root = new TreeNode(t1.val);
            root.left = mergeTrees(t1.left, null);
            root.right = mergeTrees(t1.right, null);
        } else {
            root = new TreeNode(t1.val + t2.val);
            root.left = mergeTrees(t1.left, t2.left);
            root.right = mergeTrees(t1.right, t2.right);
        }

        return root;
    }
}

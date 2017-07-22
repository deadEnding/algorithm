package leetcode.L606_ConstructStringFromBinaryTree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class Solution {
    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }

        String l = tree2str(root.left);
        String r = tree2str(root.right);
        String right = r.isEmpty() ? "" : String.format("(%s)", r);
        String left = l.isEmpty() ? (right.isEmpty() ? "" : "()") : String.format("(%s)", r);
        return root.val + left + right;
    }
}

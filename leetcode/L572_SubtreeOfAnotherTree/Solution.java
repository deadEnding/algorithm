package leetcode.L572_SubtreeOfAnotherTree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class Solution {

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        } else {
            return s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
        }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return isSame(s, t) || (s != null && (isSubtree(s.left, t) || isSubtree(s.right, t)));
    }
}

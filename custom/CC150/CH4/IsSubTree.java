package custom.CC150.CH4;

/**
 * @author: deadend
 * @date: 12:32 PM 12/28/16
 * @version: 1.0
 * @description:
 */


public class IsSubTree {

    private boolean isMatch(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 == null || t2 == null) {
            return false;
        } else {
            return t1.val == t2.val && isMatch(t1.left, t2.left) && isMatch(t1.right, t2.right);
        }
    }

    public boolean isSubTree(TreeNode t1, TreeNode t2) {
        if (t2 == null) {   // 空一定是子树
            return true;
        }

        if (t1 == null) {
            return false;
        }

        if (t1.val == t2.val && isMatch(t1, t2)) {
            return true;
        }
        return isSubTree(t1.left, t2) || isSubTree(t1.right, t2);
    }
}

package custom.CC150.CH4;

/**
 * @author: deadend
 * @date: 5:09 PM 12/27/16
 * @version: 1.0
 * @description:
 */


public class IsBST {

    private boolean isBST(TreeNode root, long from, long to) {
        if (root == null) {
            return true;
        }

        if (from < root.val && root.val < to) {
            return isBST(root.left, from, root.val) && isBST(root.right, root.val, to);
        }
        return false;
    }

    public boolean isBST(TreeNode root) {
        return isBST(root, Integer.MIN_VALUE - 1L, Integer.MAX_VALUE + 1L);
    }
}

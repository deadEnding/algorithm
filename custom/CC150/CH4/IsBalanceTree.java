package custom.CC150.CH4;

/**
 * @author: deadend
 * @date: 4:31 PM 12/27/16
 * @version: 1.0
 * @description: 判断二叉树是否是平衡树
 */

public class IsBalanceTree {

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh, rh;
        if ((lh = getDepth(root.left)) == -1 || (rh = getDepth(root.right)) == -1 || Math.abs(lh - rh) > 1) {
            return -1;
        }
        return Math.max(lh, rh) + 1;
    }

    public boolean isBalance(TreeNode root) {
        return getDepth(root) >= 0;
    }
}

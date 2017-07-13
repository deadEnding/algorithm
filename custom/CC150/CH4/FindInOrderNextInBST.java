package custom.CC150.CH4;

/**
 * @author: deadend
 * @date: 5:41 PM 12/27/16
 * @version: 1.0
 * @description: 求二叉搜索树某结点中序遍历结果的后继结点
 */


public class FindInOrderNextInBST {

    public TreeNode find(TreeNode node) {
        if (node.right != null) {
            // 求右子树的最左下角结点
            TreeNode p = node.right;
            while (p.left != null) {
                p = p.left;
            }
            return p;
        } else {
            // 向上直至当前结点是父结点的左子结点
            TreeNode c = node;       // 当前结点
            TreeNode x = c.parent;   // 其父结点
            while (x != null && x.left != x) {
                c = x;
                x = c.parent;
            }
            return x;
        }
    }
}

package custom.CC150.CH4;

/**
 * @author: deadend
 * @date: 9:25 PM 12/27/16
 * @version: 1.0
 * @description:
 */


public class LowestCommonAncestor {

    public TreeNode findLCA(TreeNode root, TreeNode n1, TreeNode n2) {
        if (root == null) {
            return null;
        }

        if (root == n1 || root == n2) {
            return root;
        }

        TreeNode left = findLCA(root.left, n1, n2);
        TreeNode right = findLCA(root.right, n1, n2);
        if (left != null && right != null) {
            return root;
        } else {
            return left != null ? left : right;
        }
    }
}

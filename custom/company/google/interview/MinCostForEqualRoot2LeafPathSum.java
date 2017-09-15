package custom.company.google.interview;

import common.tree.TreeNode;

/**
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=290121&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26sortid%3D311
 * 一棵树，所有节点的value都是正整数，问只能增加某些节点值的情况下，如何调整使得从root到所有leaf的path上经过的节点值之和相等，返回增加的值的和，使这个和最小
 * 思考：尽量增加靠近根节点的值（共享），不得已再增加叶子节点的值（独享）
 * 思路：后序遍历，使二叉树左右两子节点的 Root2LeafPathSum 相等，所有差值之和就是增加的值之和。
 *
 */


public class MinCostForEqualRoot2LeafPathSum {

    private int sum;

    private int postorder(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = postorder(root.left);
        int right = postorder(root.right);
        sum += Math.abs(left - right);
        return Math.max(left, right) + root.val;
    }

    public int minCost(TreeNode root) {
        postorder(root);
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(5);

        System.out.println(new MinCostForEqualRoot2LeafPathSum().minCost(root));
    }
}

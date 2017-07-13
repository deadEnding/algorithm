package leetcode.again.L337_HouseRobberIII;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class Solution {
    private int[] postorder(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0};
        }

        int[] left = postorder(root.left);
        int[] right = postorder(root.right);
        return new int[] {Math.max(left[0], left[1]) + Math.max(right[0], right[1]), left[0] + right[0] + root.val};
    }

    public int rob(TreeNode root) {
        int[] r = postorder(root);
        return Math.max(r[0], r[1]);
    }
}

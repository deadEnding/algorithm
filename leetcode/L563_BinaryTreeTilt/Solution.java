package leetcode.L563_BinaryTreeTilt;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {

    private int sum;

    private int postorder(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = postorder(root.left);
        int right = postorder(root.right);
        sum += Math.abs(left - right);
        return left + right + root.val;
    }

    public int findTilt(TreeNode root) {
        postorder(root);
        return sum;
    }
}

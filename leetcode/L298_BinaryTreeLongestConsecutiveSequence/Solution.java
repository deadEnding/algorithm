package leetcode.L298_BinaryTreeLongestConsecutiveSequence;

/**
 * @author: deadend
 * @date: P10:23 AM 3/P10/17
 * @version: 1.0
 * @description:
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


class Solution {
    private int max;

    private int preorder(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int curr = 1;
        int left = preorder(root.left);
        if (root.left != null && root.val + 1 == root.left.val) {
            curr = Math.max(curr, left + 1);
        }

        int right = preorder(root.right);
        if (root.right != null && root.val + 1 == root.right.val) {
            curr = Math.max(curr, right + 1);
        }

        max = Math.max(max, curr);
        return curr;
    }

    public int longestConsecutive(TreeNode root) {
        preorder(root);
        return max;
    }
}



class OldSolution {
    private int max = 0;

    private int postorder(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = postorder(root.left);
        int right = postorder(root.right);
        int curr = 1;
        if (left > 0 && root.left.val == root.val + 1) {
            curr = Math.max(curr, left + 1);
        }

        if (right > 0 && root.right.val == root.val + 1) {
            curr = Math.max(curr, right + 1);
        }
        max = Math.max(max, curr);
        return curr;
    }


    public int longestConsecutive(TreeNode root) {
        postorder(root);
        return max;
    }
}

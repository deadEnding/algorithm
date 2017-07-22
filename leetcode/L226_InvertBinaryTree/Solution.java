package leetcode.L226_InvertBinaryTree;


import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = root.left, right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }
}

class IterativeSolution {
    private void swap(TreeNode p) {
        TreeNode tmp = p.left;
        p.left = p.right;
        p.right = tmp;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            swap(p);
            if (p.left != null) {
                queue.offer(p.left);
            }

            if (p.right != null) {
                queue.offer(p.right);
            }
        }
        return root;
    }
}

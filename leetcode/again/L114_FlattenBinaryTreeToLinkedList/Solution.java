package leetcode.again.L114_FlattenBinaryTreeToLinkedList;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 1:34 PM 2/28/17
 * @version: 1.0
 * @description:
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class Solution {
    private TreeNode last;

    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        if (last != null) {
            last.left = null;
            last.right = root;
        }
        last = root;
        TreeNode right = root.right;
        preOrder(root.left);
        preOrder(right);
    }

    public void flatten(TreeNode root) {
        preOrder(root);
    }
}

class IterativeSolution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode last = new TreeNode(-1), p;
        while (!stack.isEmpty()) {
            p = stack.pop();
            if (p.right != null) {
                stack.push(p.right);
            }

            if (p.left != null) {
                stack.push(p.left);
            }

            last.left = null;
            last.right = p;
            last = p;
        }
    }
}

package leetcode.L145_BinaryTreePostorderTraversal;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 9:48 AM 12/7/16
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
    private boolean isLeaf(TreeNode node) {
        return node == null || (node.left == null && node.right == null);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;

        while (p != null || !stack.isEmpty()) {
            // 向下
            while (!isLeaf(p)) {
                stack.push(p);
                p = p.left;
            }

            if (p != null) {
                result.add(p.val);
            }

            // 向上
            while (!stack.isEmpty() && p == stack.peek().right) {
                p = stack.pop();
                result.add(p.val);
            }

            p = stack.isEmpty() ? null : stack.peek().right;
        }

        return result;
    }
}

class TrickSolution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        TreeNode p = null;
        while (!stack.isEmpty()) {
            p = stack.pop();
            result.add(0, p.val);

            if (p.left != null) {
                stack.push(p.left);
            }

            if (p.right != null) {
                stack.push(p.right);
            }
        }
        return result;
    }
}

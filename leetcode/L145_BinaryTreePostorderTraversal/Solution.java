package leetcode.L145_BinaryTreePostorderTraversal;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 4:26 PM 3/19/17
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

    private boolean shouldLeftDown(TreeNode node) {
        return node != null && (node.left != null || node.right != null);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;

        while (p != null || !stack.isEmpty()) {
            while (shouldLeftDown(p)) {
                stack.push(p);
                p = p.left;
            }

            if (p != null) {
                result.add(p.val);
            }

            // p是右子节点，一直出栈直至栈空或p成为左子节点
            while (!stack.isEmpty() && p == stack.peek().right) {
                p = stack.pop();
                result.add(p.val);   // p的父结点（即后序）
            }

            // p是左子节点
            p = stack.isEmpty() ? null : stack.peek().right;
        }

        return result;
    }
}

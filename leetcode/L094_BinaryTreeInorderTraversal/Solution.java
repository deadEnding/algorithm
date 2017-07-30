package leetcode.L094_BinaryTreeInorderTraversal;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 3:46 PM 12/2/16
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
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;

        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }

            p = stack.pop();
            result.add(p.val);
            p = p.right;
        }
        return result;
    }
}

class MainSolution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                result.add(p.val);
                p = p.right;
            }
        }

        return result;
    }
}

class OtherSolution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            while (stack.peek() != null) {
                stack.push(stack.peek().left);
            }

            stack.pop();   // 空指针出栈

            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                result.add(node.val);
                stack.push(node.right);
            }
        }
        return result;
    }
}

class RecuSolution {
    private void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root != null) {
            inorderTraversal(root.left, result);
            result.add(root.val);
            inorderTraversal(root.right, result);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        inorderTraversal(root, result);
        return result;
    }
}
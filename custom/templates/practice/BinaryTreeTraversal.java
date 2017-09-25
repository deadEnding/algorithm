package custom.templates.practice;

import common.tree.TreeNode;

import java.util.LinkedList;

public class BinaryTreeTraversal {

    public static void visit(TreeNode node) {}

    public static void preorder(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                visit(p);
                p = p.left;
            }

            p = stack.pop();
            p = p.right;
        }
    }

    public static void inorder(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }

            p = stack.pop();
            visit(p);
            p = p.right;
        }
    }

    public static void postorder(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }

            while (!stack.isEmpty() && p == stack.peek().right) {
                p = stack.pop();
                visit(p);
            }

            p = stack.isEmpty() ? null : stack.peek().right;
        }
    }
}

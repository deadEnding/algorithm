package custom.templates.finalpractice;

import common.tree.TreeNode;

import java.util.LinkedList;

/**
 * Created by deadend on 27/10/2017.
 */
public class BinaryTreeTraversal {

    public static void visit(TreeNode node) {}

    public static void preorder0(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;

        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                visit(p);
                p = p.left;
            } else {
                p = stack.pop();
                p = p.right;
            }
        }
    }

    public static void preorder1(TreeNode root) {
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


    public static void inorder0(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;

        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                visit(p);
                p = p.right;
            }
        }
    }

    public static void inorder1(TreeNode root) {
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

            while (!stack.isEmpty() && stack.peek() == p) {
                p = stack.pop();
                visit(p);
            }

            p = stack.isEmpty() ? null : stack.peek().right;
        }
    }
}

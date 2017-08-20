package custom.templates;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by deadend on 13/08/2017.
 */
public class BinaryTreeTraversal {

    class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) { this.val = val; }
    }

    public void visit(TreeNode node) {
        System.out.print(node.val + " ");
    }

    public void preorder(TreeNode root) {
        if (root == null) {
            return;
        }

        visit(root);
        preorder(root.left);
        preorder(root.right);
    }

    public void iterPreorder0(TreeNode root) {
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

    public void iterPreorder1(TreeNode root) {
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

    public void iterPreorder2(TreeNode root) {
        if (root == null) {
            return;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();
            visit(p);

            if (p.right != null) {
                stack.push(p.right);
            }

            if (p.left != null) {
                stack.push(p.left);
            }
        }
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        visit(root);
        inorder(root.right);
    }

    public void iterInorder0(TreeNode root) {
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

    public void iterInorder1(TreeNode root) {
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

    public void postorder(TreeNode root) {
        if (root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        visit(root);
    }

    public void iterPostorder(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }

            // 已访问过栈顶节点的右子树，因此直接出栈并访问
            while (!stack.isEmpty() && p == stack.peek().right) {
                p = stack.pop();
                visit(p);
            }

            // 未访问过时赋值为栈顶元素的右子树，栈空时赋值为 null
            p = stack.isEmpty() ? null : stack.peek().right;
        }
    }

    public void bfs(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            visit(p);

            if (p.left != null) {
                queue.offer(p.left);
            }

            if (p.right != null) {
                queue.offer(p.right);
            }
        }
    }
}

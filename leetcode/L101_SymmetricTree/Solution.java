package leetcode.L101_SymmetricTree;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 10:18 AM 12/3/16
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
    private boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val && isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }
}

class IterativeSolution {
    private boolean isSymmetric(TreeNode p, TreeNode q) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(p);
        stack.push(q);
        while (!stack.isEmpty()) {
            q = stack.pop();
            p = stack.pop();

            if (p == null && q == null) {
                continue;
            } else if (p == null || q == null) {
                return false;
            }

            if (p.val != q.val) {
                return false;
            }

            stack.push(p.left);
            stack.push(q.right);

            stack.push(p.right);
            stack.push(q.left);
        }
        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }
}
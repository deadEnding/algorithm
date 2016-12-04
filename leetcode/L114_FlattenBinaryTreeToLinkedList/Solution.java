package leetcode.L114_FlattenBinaryTreeToLinkedList;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 3:15 PM 12/4/16
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

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        if (last != null) {
            last.left = null;
            last.right = root;
        }

        last = root;
        TreeNode right = root.right;
        flatten(root.left);   // 会修改root
        flatten(right);
    }
}

// 不易理解
class ConciseSolution {
    private TreeNode flatten(TreeNode root, TreeNode tail) {
        if (root == null) {
            return tail;
        }

        root.right = flatten(root.left, flatten(root.right, tail));
        root.left = null;

        return root;
    }

    public void flatten(TreeNode root) {
    }
}

class RecusiveSolution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode last = null;
        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();
            if (p.right != null) {
                stack.push(p.right);
            }

            if (p.left != null) {
                stack.push(p.left);
                p.left = null;
            }

            if (last != null) {
                last.right= p;
            }
            last = p;
        }
    }
}

class PrimitiveSolution {
    private TreeNode last;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        last = root;
        flatten(root.left);   // last的值在遍历过程中进行了更新
        last.left = null;
        last.right = root.right;
        flatten(root.right);
        if (root.left != null) {
            root.right = root.left;
            root.left = null;
        }
    }
}

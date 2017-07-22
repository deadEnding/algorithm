package leetcode.L230_KthSmallestElementInABst;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 9:23 PM 3/16/17
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
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                if (--k == 0) {
                    return p.val;
                }
                p = p.right;
            }
        }
        return -1;
    }
}

class RecusiveSolution {
    private int kth;

    private TreeNode kthSmallest(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = kthSmallest(root.left);
        if (left != null) {
            return left;
        }

        if (--kth == 0) {
            return root;
        }

        return kthSmallest(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        kth = k;
        return kthSmallest(root).val;
    }
}

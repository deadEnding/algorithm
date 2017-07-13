package leetcode.L230_KthSmallestElementInABst;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 3:36 PM 12/P10/16
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

class OtherSolution {
    private int kth;

    public int kthSmallest(TreeNode root, int k) {
        kth = k;
        return findKth(root).val;
    }

    private TreeNode findKth(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = findKth(root.left);
        if (left != null) {
            return left;
        }
        if (--kth == 0) {
            return root;
        }
        return findKth(root.right);
    }
}

class RecusiveSolution {
    private int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        int lcount = countNodes(root.left);
        if (lcount + 1 == k) {
            return root.val;
        } else if (lcount + 1 > k) {
            return kthSmallest(root.left, k);
        } else {
            return kthSmallest(root.right, k - 1 - lcount);
        }
    }
}

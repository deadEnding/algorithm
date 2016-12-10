package leetcode.L230_KthSmallestElementInABst;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 3:36 PM 12/10/16
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

package leetcode.L100_SameTree;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: P10:P10 AM 12/3/16
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}


class IterativeSolution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(q);
        stack.push(p);
        while (!stack.isEmpty()) {
            p = stack.pop();
            q = stack.pop();

            if (p == null && q == null) {
                continue;
            } else if (p == null || q == null) {
                return false;
            }

            if (p.val != q.val) {
                return false;
            }

            stack.push(q.right);
            stack.push(p.right);
            
            stack.push(q.left);
            stack.push(p.left);
        }
        return true;
    }
}
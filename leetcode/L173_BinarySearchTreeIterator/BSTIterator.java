package leetcode.L173_BinarySearchTreeIterator;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 9:22 PM 12/7/16
 * @version: 1.0
 * @description:
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BSTIterator {

    private LinkedList<TreeNode> stack;
    private TreeNode p;

    public BSTIterator(TreeNode root) {
        p = root;
        stack = new LinkedList<>();
    }


    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return p != null || !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        int val = -1;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                val = p.val;
                p = p.right;
                break;
            }
        }
        return val;
    }
}

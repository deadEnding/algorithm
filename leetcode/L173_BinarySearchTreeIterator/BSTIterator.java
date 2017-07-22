package leetcode.again.L173_BinarySearchTreeIterator;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 7:22 PM 3/19/17
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

    private TreeNode p;
    private LinkedList<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        p = root;
        stack = new LinkedList<>();
    }

    private void dfs() {
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return p != null || !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        dfs();
        p = stack.pop();
        int nx = p.val;
        p = p.right;
        return nx;
    }
}

package leetcode.L111_MinimumDepthOfBinaryTree;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 9:43 AM 12/4/16
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

    private int min = 0;

    private void preorder(TreeNode root, int depth) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            min = Math.min(min == 0 ? Integer.MAX_VALUE : min, depth + 1);
        }

        preorder(root.left, depth + 1);
        preorder(root.right, depth + 1);
    }

    public int minDepth(TreeNode root) {
        preorder(root, 0);
        return min;
    }
}

class OldSolution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int level = 1;
        LinkedList<TreeNode> queue =  new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                if (node.left == null && node.right == null) {
                    return level;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            } else {
                level++;
                queue.offer(null);
            }
        }
        return -1;
    }
}

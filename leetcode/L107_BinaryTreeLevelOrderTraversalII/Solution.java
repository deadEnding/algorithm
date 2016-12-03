package leetcode.L107_BinaryTreeLevelOrderTraversalII;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 1:57 PM 12/3/16
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Integer> level = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            } else {
                result.add(0, level);
                if (!queue.isEmpty()) {
                    queue.offer(null);
                    level = new LinkedList<>();
                }
            }
        }
        return result;
    }
}
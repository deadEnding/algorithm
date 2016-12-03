package leetcode.L103_BinaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 1:11 PM 12/3/16
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
                int pos = result.size() % 2 == 0 ? level.size() : 0;
                level.add(pos, node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            } else {
                result.add(level);
                if (!queue.isEmpty()) {
                    queue.offer(null);
                    level = new LinkedList<>();
                }
            }
        }
        return result;
    }
}

class RecusiveSolution {
    private List<List<Integer>> result = new ArrayList<>();

    private void traverse(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        if (result.size() <= depth || result.get(depth) == null) {
            result.add(depth, new LinkedList<Integer>());
        }
        int pos = depth % 2 == 0 ? result.get(depth).size() : 0;
        result.get(depth).add(pos, root.val);
        traverse(root.left, depth + 1);
        traverse(root.right, depth + 1);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        traverse(root, 0);
        return result;
    }
}
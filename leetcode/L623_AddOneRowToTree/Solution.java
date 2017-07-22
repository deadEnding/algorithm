package leetcode.L623_AddOneRowToTree;

import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        TreeNode dummy = new TreeNode(-1);
        dummy.left = root;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(dummy);
        while (--d > 0) {
            queue.offer(null);
            TreeNode node;
            while ((node = queue.poll()) != null) {
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = new TreeNode(v);
            TreeNode right = new TreeNode(v);
            left.left = node.left;
            node.left = left;

            right.right = node.right;
            node.right = right;
        }

        return dummy.left;
    }
}

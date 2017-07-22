package leetcode.L102_BinaryTreeLevelOrderTraversal;


import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null)
            return result;

        LinkedList<Integer> level = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            if (p == null) {
                result.add(level);
                if (!queue.isEmpty()) {
                    level = new LinkedList<>();
                    queue.offer(null);
                }
            } else {
                level.add(p.val);
                if (p.left != null) {
                    queue.offer(p.left);
                }

                if (p.right != null) {
                    queue.offer(p.right);
                }
            }
        }

        return result;
    }
}

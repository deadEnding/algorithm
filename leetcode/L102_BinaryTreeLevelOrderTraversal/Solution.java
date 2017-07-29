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

    private void addIfNotNull(LinkedList<TreeNode> level, TreeNode node) {
        if (node != null) {
            level.add(node);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> level = new LinkedList<>();
        level.add(root);
        while (!level.isEmpty()) {
            LinkedList<Integer> nums = new LinkedList<>();
            LinkedList<TreeNode> nlevel = new LinkedList<>();

            for (TreeNode node : level) {
                nums.add(node.val);
                addIfNotNull(nlevel, node.left);
                addIfNotNull(nlevel, node.right);
            }

            result.add(nums);
            level = nlevel;
        }

        return result;
    }
}

class OldSolution {
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

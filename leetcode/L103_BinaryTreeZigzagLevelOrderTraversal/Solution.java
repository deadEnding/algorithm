package leetcode.again.L103_BinaryTreeZigzagLevelOrderTraversal;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}



public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        int depth = 0;
        LinkedList<TreeNode> level = new LinkedList<>();
        level.add(root);
        while (!level.isEmpty()) {
            LinkedList<Integer> nums = new LinkedList<>();
            LinkedList<TreeNode> nextLevel = new LinkedList<>();

            for (TreeNode node : level) {
                nums.add(node.val);
                if (node.left != null)
                    nextLevel.add(node.left);
                if (node.right != null)
                    nextLevel.add(node.right);
            }

            if (depth++ % 2 == 1)
                Collections.reverse(nums);
            result.add(nums);

            level = nextLevel;
        }

        return result;
    }
}





class FirstSolution {

    private void preorder(TreeNode root, int depth, List<List<Integer>> result) {
        if (root == null) {
            return;
        }

        if (depth >= result.size()) {
            result.add(new LinkedList<>());
        }

        int pos = depth % 2 == 0 ? result.get(depth).size() : 0;
        result.get(depth).add(pos, root.val);
        preorder(root.left, depth + 1, result);
        preorder(root.right, depth + 1, result);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        preorder(root, 0, result);
        return result;
    }
}

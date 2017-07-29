package leetcode.L113_PathSumII;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: P10:09 AM 12/4/16
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
    private List<List<Integer>> result = new LinkedList<>();

    private void preorder(TreeNode root, int sum, LinkedList<Integer> path) {
        if (root == null) {
            return;
        }

        int remain = sum - root.val;
        path.addLast(root.val);
        if (root.left == null && root.right == null && remain == 0) {
            result.add(new LinkedList<>(path));
        }

        preorder(root.left, remain, path);
        preorder(root.right, remain, path);
        path.removeLast();
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        preorder(root, sum, new LinkedList<Integer>());
        return result;
    }
}

class OldSolution {
    private List<List<Integer>> result = new LinkedList<>();

    private void preorder(TreeNode root, int sum, LinkedList<Integer> path) {
        if (root == null) {
            return;
        }

        int remain = sum - root.val;
        path.addLast(root.val);
        if (root.left == null && root.right == null && remain == 0) {
            result.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }

        preorder(root.left, remain, path);
        preorder(root.right, remain, path);
        path.removeLast();
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        preorder(root, sum, new LinkedList<Integer>());
        return result;
    }
}

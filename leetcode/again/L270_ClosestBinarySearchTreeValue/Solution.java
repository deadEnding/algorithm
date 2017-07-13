package leetcode.again.L270_ClosestBinarySearchTreeValue;

/**
 * @author: deadend
 * @date: 5:37 PM 3/12/17
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
    public int closestValue(TreeNode root, double target) {
        TreeNode kid = target < root.val ? root.left : root.right;
        if (kid == null) {
            return root.val;
        }
        int b = closestValue(kid, target);
        return Math.abs(root.val - target) < Math.abs(b - target) ? root.val : b;
    }
}

class BasicSolution {
    private Integer closest = null;

    private void traversal(TreeNode root, double target) {
        if (root == null) {
            return;
        }

        if (closest == null || Math.abs(root.val - target) < Math.abs(closest - target)) {
            closest = root.val;
        }

        if (root.val < target) {
            traversal(root.right, target);
        } else {
            traversal(root.left, target);
        }
    }

    public int closestValue(TreeNode root, double target) {
        traversal(root, target);
        return closest;
    }
}

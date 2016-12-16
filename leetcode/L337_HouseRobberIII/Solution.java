package leetcode.L337_HouseRobberIII;

/**
 * @author: deadend
 * @date: 2:57 PM 12/16/16
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
    public int[] doRob(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] left = doRob(root.left);
        int[] right = doRob(root.right);
        return new int[]{Math.max(left[0], left[1]) +
                Math.max(right[0], right[1]), left[0] + right[0] + root.val};
    }

    public int rob(TreeNode root) {
        int[] curr = doRob(root);
        return Math.max(curr[0], curr[1]);
    }
}

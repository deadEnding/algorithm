package leetcode.L222_CountCompleteTreeNodes;

/**
 * @author: deadend
 * @date: 11:15 PM 12/9/16
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
    private int aleftHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            height++;
            root = root.left;
        }
        return height;
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = aleftHeight(root.left);
        int rh = aleftHeight(root.right);

        if (lh == rh) {
            return (1 << lh) + countNodes(root.right);
        }
        return countNodes(root.left) + (1 << rh);
    }
}

package leetcode.again.L222_CountCompleteTreeNodes;

/**
 * @author: deadend
 * @date: 5:11 PM 2/28/17
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
    private int getHeight(TreeNode root) {
        int h = 0;
        while (root != null) {
            h++;
            root = root.left;
        }
        return h;
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = getHeight(root.left);
        int rh = getHeight(root.right);
        if (lh == rh) {
            return (1 << lh) + countNodes(root.right);
        } else {
            return (1 << rh) + countNodes(root.left);
        }
    }
}

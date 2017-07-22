package leetcode.L501_FindModeInBinarySearchTree;

import java.util.ArrayList;

/**
 * @author: deadend
 * @date: 3:12 PM 28/03/2017
 */


class TreeNode {
    int val;TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    private ArrayList<Integer> values = new ArrayList<>();
    private int max = 0;
    private int cur = 0;
    private TreeNode last;

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        if (last != null && last.val != root.val) {
            cur = 0;
        }
        cur++;
        if (cur >= max) {
            if (cur > max) {
                values.clear();
                max = cur;
            }
            values.add(root.val);
        }
        last = root;
        inorder(root.right);
    }

    public int[] findMode(TreeNode root) {
        inorder(root);
        int[] result = new int[values.size()];
        for (int i = 0; i < values.size(); i++) {
            result[i] = values.get(i);
        }
        return result;
    }
}

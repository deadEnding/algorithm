package leetcode.L513_FindLeftMostElement;

import java.util.ArrayList;

/**
 * @author: deadend
 * @date: 12:52 PM 2/12/17
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
    private void preorder(TreeNode root, int depth, ArrayList<Integer> levelFirst) {
        if (root == null) {
            return;
        }

        if (depth >= levelFirst.size()) {
            levelFirst.add(root.val);
        }
        preorder(root.left, depth + 1, levelFirst);
        preorder(root.right, depth + 1, levelFirst);
    }

    public int findLeftMostNode(TreeNode root) {
        ArrayList<Integer> levelFirst = new ArrayList<>();
        preorder(root, 0, levelFirst);
        return levelFirst.get(levelFirst.size() - 1);
    }
}

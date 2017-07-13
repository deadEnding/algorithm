package leetcode.L515_FindLargestElementInEachRow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: deadend
 * @date: 1:02 PM 2/12/17
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
    private void preorder(TreeNode root, int depth, ArrayList<Integer> levelMax) {
        if (root == null) {
            return;
        }

        if (depth >= levelMax.size()) {
            levelMax.add(root.val);
        } else {
            levelMax.set(depth, Math.max(levelMax.get(depth), root.val));
        }
        preorder(root.left, depth + 1, levelMax);
        preorder(root.right, depth + 1, levelMax);
    }

    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> levelMax = new ArrayList<>();
        preorder(root, 0, levelMax);
        return levelMax;
    }
}

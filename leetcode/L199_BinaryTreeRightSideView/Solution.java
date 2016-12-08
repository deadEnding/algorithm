package leetcode.L199_BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: deadend
 * @date: 3:08 PM 12/8/16
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
    private void dfs(TreeNode root, int depth, ArrayList<Integer> result) {
        if (root != null) {
            if (result.size() <= depth) {
                result.add(depth, root.val);
            } else {
                result.set(depth, root.val);
            }
            dfs(root.left, depth + 1, result);
            dfs(root.right, depth + 1, result);
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }
}

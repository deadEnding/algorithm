package leetcode.again.L515_FindLargestValueInEachTreeRow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: deadend
 * @date: 9:33 PM 28/03/2017
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    private void preorder(TreeNode root, List<Integer> max, int depth) {
        if (root == null) {
            return;
        }

        if (depth == max.size()) {
            max.add(root.val);
        } else {
            max.set(depth, Math.max(max.get(depth), root.val));
        }

        preorder(root.left, max, depth + 1);
        preorder(root.right, max, depth + 1);
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> max = new ArrayList<>();
        preorder(root, max, 0);
        return max;
    }
}

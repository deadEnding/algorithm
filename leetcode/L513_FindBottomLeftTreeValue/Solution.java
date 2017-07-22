package leetcode.L513_FindBottomLeftTreeValue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: deadend
 * @date: 7:50 PM 28/03/2017
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode p = null;
        while (!queue.isEmpty()) {
            p = queue.poll();
            result = p.val;
            if (p.right != null) {
                queue.offer(p.right);
            }

            if (p.left != null) {
                queue.offer(p.left);
            }
        }

        return result;
    }
}

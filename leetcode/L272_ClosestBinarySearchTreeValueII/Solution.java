package leetcode.L272_ClosestBinarySearchTreeValueII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 6:06 PM 3/16/17
 * @version: 1.0
 * @description: O(logn + k)解法 https://discuss.leetcode.com/topic/23151/o-logn-java-solution-with-two-stacks-following-hint
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


// O(n + k)
public class Solution {
    private void inorder(TreeNode root, double target, boolean reverse, LinkedList<Integer> stack) {
        if (root == null) {
            return;
        }

        inorder(reverse ? root.right : root.left, target, reverse, stack);
        if (reverse && root.val <= target || !reverse && root.val > target) {
            return;
        }
        stack.push(root.val);
        inorder(reverse ? root.left : root.right, target, reverse, stack);
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> lteVals = new LinkedList<>();
        LinkedList<Integer> gtVals = new LinkedList<>();

        inorder(root, target, false, lteVals);
        inorder(root, target, true, gtVals);

        List<Integer> result = new ArrayList<>(k);

        for (int i = 0; i < k; i++) {
            if (gtVals.isEmpty()) {
                result.add(lteVals.pop());
            } else if (lteVals.isEmpty()) {
                result.add(gtVals.pop());
            } else if (Math.abs(lteVals.peek() - target) < Math.abs(gtVals.peek() - target)) {
                result.add(lteVals.pop());
            } else {
                result.add(gtVals.pop());
            }
        }
        return result;
    }
}

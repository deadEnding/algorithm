package leetcode.again.L315_CountOfSmallerNumbersAfterSelf;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: P10:42 AM 3/12/17
 * @version: 1.0
 * @description:
 */


public class Solution {

    class TreeNode {
        int val, dup, leftCount;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.dup = 1;
        }
    }

    private TreeNode insert(TreeNode root, int val, List<Integer> counter) {
        if (root == null) {
            root = new TreeNode(val);
        } else if (root.val == val) {
            counter.set(0, counter.get(0) + root.leftCount);
            root.dup++;
        } else if (root.val < val) {
            counter.set(0, counter.get(0) + root.leftCount + root.dup);
            root.right = insert(root.right, val, counter);
        } else {
            root.leftCount++;
            root.left = insert(root.left, val, counter);
        }
        return root;
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> counter = new LinkedList<>();
        TreeNode root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            counter.add(0, 0);
            root = insert(root, nums[i], counter);
        }
        return counter;
    }
}

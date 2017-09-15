package leetcode.L315_CountOfSmallerNumbersAfterSelf;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: P10:42 AM 3/12/17
 * @version: 1.0
 * @description:
 */


class Solution {
    class Node {
        int val, dup, leftCount;
        Node left, right;
        public Node(int val) {
            this.val = val;
            this.dup = 1;
        }
    }

    private Node root;

    private Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
        } else if (root.val == val) {
            root.dup++;
        } else if (root.val > val) {
            root.leftCount++;
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    private int search(Node root, int val) {
        if (root == null) {
            return 0;
        } else if (root.val == val) {
            return root.leftCount;
        } else if (root.val > val) {
            return search(root.left, val);
        } else {
            return root.dup + root.leftCount + search(root.right, val);
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        final int n = nums.length;
        List<Integer> count = new LinkedList<>();

        for (int i = n - 1; i >= 0; i--) {
            root = insert(root, nums[i]);
            count.add(0, search(root, nums[i]));
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {5,2,6,1};
        System.out.println(new Solution().countSmaller(nums));
    }
}


class OldSolution {

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

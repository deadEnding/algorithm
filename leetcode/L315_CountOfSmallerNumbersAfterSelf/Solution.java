package leetcode.L315_CountOfSmallerNumbersAfterSelf;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 8:44 PM 12/14/16
 * @version: 1.0
 * @description:
 */

public class Solution {
    class Node {
        int val, dup;
        int count;
        Node left, right;
        public Node(int val) {
            this.val = val;
            this.dup = 1;
        }
    }

    private Node insert(Node root, int num, int preCount, List<Integer> result) {
        if (root == null) {
            root = new Node(num);
            result.add(0, preCount);
        } else if (num == root.val) {
            root.dup++;
            result.add(0, preCount + root.count);
        } else if (num < root.val) {
            root.count++;
            root.left = insert(root.left, num, preCount, result);
        } else {    // num > root.val
            root.right = insert(root.right, num, preCount + root.dup + root.count, result);
        }
        return root;
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new LinkedList<>();
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(root, nums[i], 0, result);
        }
        return result;
    }
}


class SegmentTreeSolution {
    class SegmentTreeNode {
        int start, end;
        int count = 0;
        SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private SegmentTreeNode insert(SegmentTreeNode root, int num, int start, int end, int preCount, List<Integer> result) {
        if (root == null) {
            root = new SegmentTreeNode(start, end);
        }

        if (start == num && num == end) {
            result.add(0, preCount);
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (num <= mid) {
                root.left = insert(root.left, num, start, mid, preCount, result);
            } else {
                root.right = insert(root.right, num, mid + 1, end, preCount + (root.left == null ? 0 : root.left.count), result);
            }

        }
        root.count++;
        return root;
    }

    public List<Integer> countSmaller(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        List<Integer> result = new LinkedList<>();
        SegmentTreeNode root = new SegmentTreeNode(min, max);
        for (int i = nums.length - 1; i >= 0; i--) {
            insert(root, nums[i], min, max, 0, result);
        }
        return result;
    }
}

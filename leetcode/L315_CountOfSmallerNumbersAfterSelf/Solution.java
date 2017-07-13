package leetcode.L315_CountOfSmallerNumbersAfterSelf;

import java.util.*;

/**
 * @author: deadend
 * @date: 8:44 PM 12/14/16
 * @version: 1.0
 * @description:
 */


// 二叉索引树 / 树状数组
public class Solution {

    private int[] sum;

    private void update(int i, int val) {
        while (i < sum.length) {
            sum[i] += val;
            i += lowestBit(i);
        }
    }

    private int sum(int i) {
        int s = 0;
        while (i > 0) {
            s += sum[i];
            i -= lowestBit(i);
        }
        return s;
    }

    private int lowestBit(int n) {
        return n & -n;
    }

    public List<Integer> countSmaller(int[] nums) {
        int[] numscp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numscp);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0, ix = 1; i < numscp.length; i++) {
            if (i == 0 || numscp[i] != numscp[i - 1]) {
                map.put(numscp[i], ix++);
            }
        }

        sum = new int[map.size() + 1];
        List<Integer> result = new ArrayList<>(nums.length);
        for (int i = nums.length - 1; i >= 0; i--) {
            result.add(0, sum(map.get(nums[i]) - 1));
            update(map.get(nums[i]), 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3,3,1,1};
        List<Integer> count = new Solution().countSmaller(nums);
        System.out.println(count.toString());
    }
}


class BinarySearchTreeSolution {
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

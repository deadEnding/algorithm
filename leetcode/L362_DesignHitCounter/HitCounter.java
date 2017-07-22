package leetcode.L362_DesignHitCounter;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 5:29 PM 3/11/17
 * @version: 1.0
 * @description:
 */

public class HitCounter {

    private LinkedList<int[]> queue;
    private int THRESHOLD = 300;
    private int hits;

    /** Initialize your data structure here. */
    public HitCounter() {
        queue = new LinkedList<>();
    }

    private void check(int timestamp) {
        while (!queue.isEmpty() && queue.getFirst()[0] + THRESHOLD <= timestamp) {
            hits -= queue.removeFirst()[1];
        }
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        hits++;
        check(timestamp);
        if (queue.size() > 0 && queue.getLast()[0] == timestamp) {
            queue.getLast()[1]++;
        } else {
            queue.addLast(new int[] {timestamp, 1});
        }
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        check(timestamp);
        return hits;
    }
}

class BSTHitCounter {

    class TreeNode {
        int val, dup, leftCount;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
            dup = 1;
        }
    }

    TreeNode root;

    /** Initialize your data structure here. */
    public BSTHitCounter() {
    }

    private TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
        } else if (root.val == val) {
            root.dup++;
        } else if (root.val < val) {
            root.right = insert(root.right, val);
        } else {
            root.leftCount++;
            root.left = insert(root.left, val);
        }
        return root;
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        root = insert(root, timestamp);
    }

    private int search(TreeNode root, int val) {
        if (root == null) {
            return 0;
        } else if (root.val == val) {
            return root.leftCount + root.dup;
        } else if (root.val < val) {
            return root.leftCount + root.dup + search(root.right, val);
        } else {
            return search(root.left, val);
        }
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        return search(root, timestamp) - search(root, timestamp - 300);
    }
}

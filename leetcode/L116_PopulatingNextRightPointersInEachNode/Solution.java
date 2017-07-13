package leetcode.L116_PopulatingNextRightPointersInEachNode;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: P10:18 AM 12/5/16
 * @version: 1.0
 * @description:
 */

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}

public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        TreeLinkNode head = root, curr = null;
        while (head.left != null) {
            curr = head;
            while (curr != null) {
                curr.left.next = curr.right;
                if (curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            head = head.left;
        }

    }
}

class RecusiveSolution {
    public void connect(TreeLinkNode root) {
        if (root == null || root.left == null || root.right == null) {
            return;
        }

        TreeLinkNode prev = null, curr = root;
        while (curr != null) {
            curr.left.next = curr.right;
            if (prev != null) {
                prev.right.next = curr.left;
            }
            prev = curr;
            curr = curr.next;
        }
        connect(root.left);
    }
}

class BasicSolution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        TreeLinkNode last = null;
        while (!queue.isEmpty()) {
            TreeLinkNode node = queue.poll();
            if (node != null) {
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            } else {
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
            }
            if (last != null) {
                last.next = node;
            }
            last = node;
        }
    }
}

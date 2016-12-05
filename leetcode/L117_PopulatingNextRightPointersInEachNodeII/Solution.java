package leetcode.L117_PopulatingNextRightPointersInEachNodeII;

/**
 * @author: deadend
 * @date: 11:12 AM 12/5/16
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
        for (TreeLinkNode head = root; head != null;) {
            TreeLinkNode newHead = new TreeLinkNode(-1), tail = newHead;
            for (TreeLinkNode curr = head; curr != null; curr = curr.next) {
                if (curr.left != null) {
                    tail.next = curr.left;
                    tail = tail.next;
                }

                if (curr.right != null) {
                    tail.next = curr.right;
                    tail = tail.next;
                }
            }
            head = newHead.next;
        }
    }
}

class BasicSolution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode head = root, curr = null;
        while (head != null) {
            while (head != null && head.left == null && head.right == null) {
                head = head.next;
            }
            if (head == null) {
                break;
            }

            curr = head;
            TreeLinkNode last = null;
            while (curr != null) {
                if (curr.left != null) {
                    if (last != null) {
                        last.next = curr.left;
                    }
                    last = curr.left;
                }

                if (curr.right != null) {
                    if (last != null) {
                        last.next = curr.right;
                    }
                    last = curr.right;
                }
                curr = curr.next;
            }
            head = head.left != null ? head.left : head.right;
        }
    }
}
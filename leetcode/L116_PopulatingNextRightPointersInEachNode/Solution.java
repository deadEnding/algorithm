package leetcode.L116_PopulatingNextRightPointersInEachNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 1:51 PM 2/28/17
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

        TreeLinkNode dummy = new TreeLinkNode(-1);
        for (TreeLinkNode h = root; h.left != null; h = h.left) {
            for (TreeLinkNode p = h, last = dummy; p != null; p = p.next) {
                last.next = p.left;
                p.left.next = p.right.next;
                last = p.right;
            }
        }
    }
}


class OldSolution {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;

        for (TreeLinkNode head = root; head.left != null; head = head.left) {
            for (TreeLinkNode p = head, last = new TreeLinkNode(-1); p != null; p = p.next) {
                last.next = p.left;
                p.left.next = p.right;
                last = p.right;
            }
        }
    }
}

class RecursiveSolution {
    private void preorder(TreeLinkNode root, int h, ArrayList<TreeLinkNode> lasts) {
        if (root == null)
            return;

        if (h >= lasts.size()) {
            lasts.add(new TreeLinkNode(-1));
        }
        lasts.get(h).next = root;
        lasts.set(h, root);
        preorder(root.left, h + 1, lasts);
        preorder(root.right, h + 1, lasts);
    }

    public void connect(TreeLinkNode root) {
        preorder(root, 0, new ArrayList<>());
    }
}

class BFSSolution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        LinkedList<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        TreeLinkNode dummy = new TreeLinkNode(-1);
        TreeLinkNode last = dummy;
        while (!queue.isEmpty()) {
            TreeLinkNode p = queue.poll();
            last.next = p;
            last = p;
            if (p == null) {
                if (!queue.isEmpty()) {
                    queue.offer(null);
                    last = dummy;
                }
            } else {
                if (p.left != null) {
                    queue.offer(p.left);
                }

                if (p.right != null) {
                    queue.offer(p.right);
                }
            }
        }
    }
}





























class FirstSolution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        TreeLinkNode dummy = new TreeLinkNode(-1);
        TreeLinkNode head = root;
        while (head.left != null) {
            TreeLinkNode prev = dummy;
            for (TreeLinkNode p = head; p != null; p = p.next) {
                if (p.left != null) {
                    prev.next = p.left;
                    p.left.next = p.right;
                    prev = p.right;
                } else {
                    break;
                }
            }
            head = head.left;
        }
    }
}

package leetcode.L117_PopulatingNextRightPointersInEachNodeII;


class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}


public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;

        for (TreeLinkNode head = root; head != null;) {
            TreeLinkNode dummy = new TreeLinkNode(-1);
            TreeLinkNode last = dummy;
            for (TreeLinkNode p = head; p != null; p = p.next) {
                if (p.left != null) {
                    last.next = p.left;
                    last = p.left;
                }

                if (p.right != null) {
                    last.next = p.right;
                    last = p.right;
                }
            }

            head = dummy.next;
        }
    }
}

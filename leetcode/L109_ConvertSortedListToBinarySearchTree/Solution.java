package leetcode.L109_ConvertSortedListToBinarySearchTree;

/**
 * @author: deadend
 * @date: 9:28 PM 12/3/16
 * @version: 1.0
 * @description:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    private ListNode current;

    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    private TreeNode build(int s, int e) {
        if (s == e) {
            return null;
        }

        int rootPos = s + (e - s) / 2;
        TreeNode left = build(s, rootPos);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        root.left = left;
        root.right = build(rootPos + 1, e);

        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        current = head;
        return build(0, getLength(head));
    }
}

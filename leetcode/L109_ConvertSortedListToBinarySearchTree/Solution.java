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

// 中序遍历，指针跟踪
public class Solution {

    private int length(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }

        return len;
    }

    private ListNode current;

    private TreeNode sortedListToBST(int s, int e) {
        if (s > e) {
            return null;
        }

        int m = s + (e - s) / 2;
        TreeNode left = sortedListToBST(s, m - 1);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        root.left = left;
        root.right = sortedListToBST(m + 1, e);
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        current = head;
        return sortedListToBST(0, length(head) - 1);
    }
}

class OldSolution {
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

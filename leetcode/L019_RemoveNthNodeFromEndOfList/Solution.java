package leetcode.L019_RemoveNthNodeFromEndOfList;

/**
 * @author: deadend
 * @date: 9:14 AM 11/29/16
 * @version: 1.0
 * @description:
 */


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = dummy;

        for (int i = 0; i < n; i++) {
            p = p.next;
        }

        while (p.next != null) {
            p = p.next;
            q = q.next;
        }

        q.next = q.next.next;
        return dummy.next;
    }
}

class BasicSolution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int len = 0;
        while (curr != null) {
            len++;
            curr = curr.next;
        }

        if (len == n) {
            return head.next;
        }

        curr = head;
        for (int i = 0; i < len - 1 - n; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }
}

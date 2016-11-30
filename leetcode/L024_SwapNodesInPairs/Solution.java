package leetcode.L024_SwapNodesInPairs;

/**
 * @author: deadend
 * @date: 9:39 AM 11/30/16
 * @version: 1.0
 * @description:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode d = dummy;
        while (d.next != null && d.next.next != null) {
            ListNode p = d.next.next;
            d.next.next = p.next;
            p.next = d.next;
            d.next = p;
            d = p.next;
        }
        return dummy.next;
    }
}

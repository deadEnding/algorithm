package leetcode.L086_PartitionList;

/**
 * @author: deadend
 * @date: 8:46 PM 12/1/16
 * @version: 1.0
 * @description:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smaller = new ListNode(-1), bigger = new ListNode(-1);
        ListNode s = smaller, b = bigger;

        for (ListNode p = head; p != null; p = p.next) {
            if (p.val < x) {
                s.next = p;
                s = s.next;
            } else {
                b.next = p;
                b = b.next;
            }
        }

        s.next = bigger.next;
        b.next = null;
        return smaller.next;
    }
}


class OtherSolution {
    public ListNode partition(ListNode head, int x) {
        ListNode lt = new ListNode(-1);
        ListNode ge = new ListNode(-1);
        ListNode ltTail = lt, geTail = ge, curr = head;

        while (curr != null) {
            if (curr.val < x) {
                ltTail.next = curr;
                ltTail = curr;
            } else {
                geTail.next = curr;
                geTail = curr;
            }
            curr = curr.next;
        }
        ltTail.next = ge.next;
        geTail.next = null;
        return lt.next;
    }
}

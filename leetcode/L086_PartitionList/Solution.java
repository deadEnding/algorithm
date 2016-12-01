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

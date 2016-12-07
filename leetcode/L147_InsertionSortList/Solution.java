package leetcode.L147_InsertionSortList;

/**
 * @author: deadend
 * @date: 1:24 PM 12/7/16
 * @version: 1.0
 * @description:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);

        for (ListNode curr = head; curr != null;) {
            ListNode p = dummy;
            while (p.next != null && p.next.val < curr.val) {
                p = p.next;
            }
            ListNode tmp = curr.next;
            curr.next = p.next;
            p.next = curr;
            curr = tmp;
        }
        return dummy.next;
    }
}

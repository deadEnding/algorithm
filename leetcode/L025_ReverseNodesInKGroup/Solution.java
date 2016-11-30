package leetcode.L025_ReverseNodesInKGroup;

/**
 * @author: deadend
 * @date: 9:55 AM 11/30/16
 * @version: 1.0
 * @description:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        ListNode p;
        for (p = head; len < k && p != null; len++, p = p.next) {}

        if (len < k) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode last = head;
        for (int i = 1; i < k; i++) {
            ListNode tmp = last.next;
            last.next = tmp.next;
            tmp.next = dummy.next;
            dummy.next = tmp;
        }
        last.next = reverseKGroup(p, k);
        return dummy.next;
    }
}

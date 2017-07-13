package leetcode.L002_AddTwoNumbers;

/**
 * @author: deadend
 * @date: P10:16 AM 11/27/16
 * @version: 1.0
 * @description:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        int c = 0;
        ListNode curr = dummy;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                c += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                c += l2.val;
                l2 = l2.next;
            }

            curr.next = new ListNode(c % 10);
            c /= 10;
            curr = curr.next;
        }
        if (c == 1) {
            curr.next = new ListNode(c);
        }
        return dummy.next;
    }
}
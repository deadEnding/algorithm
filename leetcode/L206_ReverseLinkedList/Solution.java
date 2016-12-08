package leetcode.L206_ReverseLinkedList;

/**
 * @author: deadend
 * @date: 7:48 PM 12/8/16
 * @version: 1.0
 * @description:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode tail = head, tmp = null;
        while (tail != null && tail.next != null) {
            tmp = tail.next;
            tail.next = tail.next.next;
            tmp.next = dummy.next;
            dummy.next = tmp;
        }
        return dummy.next;
    }
}

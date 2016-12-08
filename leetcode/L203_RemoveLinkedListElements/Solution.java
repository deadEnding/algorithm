package leetcode.L203_RemoveLinkedListElements;

/**
 * @author: deadend
 * @date: 7:40 PM 12/8/16
 * @version: 1.0
 * @description:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = head, tail = dummy;
        while (curr != null) {
            if (curr.val != val) {
                tail.next = curr;
                tail = curr;
            }
            curr = curr.next;
        }
        tail.next = null;
        return dummy.next;
    }
}

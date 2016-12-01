package leetcode.L083_RemoveDuplicatesFromSortedList;

/**
 * @author: deadend
 * @date: 8:41 PM 12/1/16
 * @version: 1.0
 * @description:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = head, tail = dummy;
        while (curr != null) {
            if (curr.next == null || curr.val != curr.next.val) {
                tail.next = curr;
                tail = curr;
            }
            curr = curr.next;
        }
        tail.next = null;
        return dummy.next;
    }
}

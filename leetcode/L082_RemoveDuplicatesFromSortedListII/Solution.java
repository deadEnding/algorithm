package leetcode.L082_RemoveDuplicatesFromSortedListII;

/**
 * @author: deadend
 * @date: 5:15 PM 12/1/16
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
        ListNode tail = dummy, curr = head;
        while (curr != null) {
            if (curr.next == null || curr.next.val != curr.val) {
                tail.next = curr;
                tail = curr;
                curr = curr.next;
            } else {
                int v = curr.val;
                do {
                    curr = curr.next;
                } while (curr != null && curr.val == v);
            }
        }
        return dummy.next;
    }
}

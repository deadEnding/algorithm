package leetcode.again.L019_RemoveNthNodeFromEndOfList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode p = dummy;
        while (n-- > 0) {
            p = p.next;
        }

        ListNode q = dummy;
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }

        q.next = q.next.next;
        return dummy.next;
    }
}

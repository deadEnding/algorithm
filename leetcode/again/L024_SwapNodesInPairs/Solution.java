package leetcode.again.L024_SwapNodesInPairs;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        while (prev.next != null && prev.next.next != null) {
            ListNode t = prev.next;
            prev.next = t.next;
            t.next = prev.next.next;
            prev.next.next = t;
            prev = t;
        }

        return dummy.next;
    }
}

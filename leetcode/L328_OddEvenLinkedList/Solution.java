package leetcode.L328_OddEvenLinkedList;

/**
 * @author: deadend
 * @date: 10:29 AM 12/16/16
 * @version: 1.0
 * @description:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddDummy = new ListNode(-1);
        ListNode evenDummy = new ListNode(-1);

        ListNode p = oddDummy, q = evenDummy;
        int ix = 1;
        for (ListNode curr = head; curr != null; curr = curr.next, ix++) {
            if (ix % 2 == 1) {
                p.next = curr;
                p = p.next;
            } else {
                q.next = curr;
                q = q.next;
            }
        }
        p.next = evenDummy.next;
        q.next = null;
        return oddDummy.next;
    }
}

class OtherSolution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head, even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}

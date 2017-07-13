package leetcode.again.L002_AddTwoNumbers;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode r = dummy;

        int c = 0;
        for (ListNode p = l1, q = l2; p != null || q != null;) {
            int a = p == null ? 0 : p.val;
            p = p == null ? null : p.next;
            int b = q == null ? 0 : q.val;
            q = q == null ? null : q.next;

            int s = a + b + c;
            c = s / 10;
            r.next = new ListNode(s % 10);
            r = r.next;
        }

        if (c != 0) {
            r.next = new ListNode(c);
        }

        return dummy.next;
    }
}

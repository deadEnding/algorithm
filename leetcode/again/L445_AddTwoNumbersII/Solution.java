package leetcode.again.L445_AddTwoNumbersII;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


public class Solution {
    private ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(-1);

        while (head != null) {
            ListNode t = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = t;
        }

        return dummy.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rl1 = reverse(l1);
        ListNode rl2 = reverse(l2);
        ListNode dummy = new ListNode(-1);
        ListNode r = dummy;

        int c = 0;
        for (ListNode p = rl1, q = rl2; p != null || q != null;) {
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

        return reverse(dummy.next);
    }
}

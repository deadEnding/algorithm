package leetcode.again.L025_ReverseNodesInKGroup;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {

    private int lengthOf(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }

        return len;
    }

    private ListNode reverseKGroup(ListNode head, int k, int len) {
        if (len < k) {
            return head;
        }

        ListNode dummy = new ListNode(-1);

        ListNode p = head;
        for (int i = 0; i < k; i++) {
            ListNode tmp = p;
            p = p.next;
            tmp.next = dummy.next;
            dummy.next = tmp;
        }

        head.next = reverseKGroup(p, k, len - k);
        return dummy.next;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        return reverseKGroup(head, k, lengthOf(head));
    }
}

class OldSolution {

    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    private ListNode reverse(ListNode head, int k, int len) {
        if (len < k) {
            return head;
        }

        ListNode dummy = new ListNode(-1), p = head, next = null;
        for (int i = 0; i < k; i++) {
            next = p.next;
            p.next = dummy.next;
            dummy.next = p;
            p = next;
        }

        head.next = reverse(next, k, len - k);
        return dummy.next;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        int len = getLength(head);
        return reverse(head, k, len);
    }
}

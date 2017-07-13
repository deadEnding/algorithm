package leetcode.again.L025_ReverseNodesInKGroup;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


public class Solution {

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

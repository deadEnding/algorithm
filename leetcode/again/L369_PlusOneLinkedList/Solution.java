package leetcode.again.L369_PlusOneLinkedList;

/**
 * @author: deadend
 * @date: 7:59 PM 3/12/17
 * @version: 1.0
 * @description:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    private int plus(ListNode head) {
        if (head == null) {
            return 1;
        }

        head.val += plus(head.next);
        int c = head.val / 10;
        head.val %= 10;
        return c;
    }

    public ListNode plusOne(ListNode head) {
        int c = plus(head);
        if (c == 0) {
            return head;
        }

        ListNode newHead = new ListNode(c);
        newHead.next = head;
        return newHead;
    }
}

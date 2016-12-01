package leetcode.L061_RotateList;

/**
 * @author: deadend
 * @date: 1:49 PM 12/1/16
 * @version: 1.0
 * @description:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode tail = null;
        ListNode curr = head;
        int len = 0;
        while (curr != null) {
            len++;
            tail = curr;
            curr = curr.next;
        }

        if (len == 0 || k % len == 0) {
            return head;
        }

        int step = len - k % len;
        curr = head;
        for (int i = 1; i < step; i++) {
            curr = curr.next;
        }

        tail.next = head;
        head = curr.next;
        curr.next = null;
        return head;
    }
}

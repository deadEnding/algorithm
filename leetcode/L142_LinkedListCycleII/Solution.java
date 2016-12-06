package leetcode.L142_LinkedListCycleII;

/**
 * @author: deadend
 * @date: 8:02 PM 12/6/16
 * @version: 1.0
 * @description:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        ListNode start = head;
        while (start != slow) {
            start = start.next;
            slow = slow.next;
        }

        return start;
    }
}

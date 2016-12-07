package leetcode.L143_ReorderList;

/**
 * @author: deadend
 * @date: 8:23 PM 12/6/16
 * @version: 1.0
 * @description:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    private ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode last = head;
        while (last.next != null) {
            ListNode tmp  = last.next;
            last.next = last.next.next;
            tmp.next = dummy.next;
            dummy.next = tmp;
        }
        return dummy.next;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode rear = slow.next;
        slow.next = null;
        rear = reverse(rear);

        ListNode front = head;
        while (rear != null) {
            ListNode tmp = rear;
            rear = rear.next;
            tmp.next = front.next;
            front.next = tmp;
            front = front.next.next;
        }
    }
}

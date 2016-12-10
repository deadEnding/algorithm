package leetcode.L234_PalindromeLinkedList;

/**
 * @author: deadend
 * @date: 8:30 PM 12/10/16
 * @version: 1.0
 * @description:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = slow.next;
        slow.next = null;

        ListNode q = dummy.next;
        while (q != null && q.next != null) {
            ListNode tmp = q.next;
            q.next = q.next.next;
            tmp.next = dummy.next;
            dummy.next = tmp;
        }

        ListNode p = head;
        q = dummy.next;
        while (q != null) {
            if (p.val != q.val) {
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;
    }
}

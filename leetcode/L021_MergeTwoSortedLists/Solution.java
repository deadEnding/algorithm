package leetcode.L021_MergeTwoSortedLists;

/**
 * @author: deadend
 * @date: 9:38 AM 11/29/16
 * @version: 1.0
 * @description:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (l1 != null || l2 != null) {
            int x1 = l1 != null ? l1.val : Integer.MAX_VALUE;
            int x2 = l2 != null ? l2.val : Integer.MAX_VALUE;
            if (x1 < x2) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}

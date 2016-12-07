package leetcode.L148_SortList;

/**
 * @author: deadend
 * @date: 1:47 PM 12/7/16
 * @version: 1.0
 * @description:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        for (ListNode p = dummy; l1 != null || l2 != null; p = p.next) {
            long v1 = l1 == null ? Integer.MAX_VALUE + 1L : l1.val;
            long v2 = l2 == null ? Integer.MAX_VALUE + 1L : l2.val;
            if (v1 <= v2) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
        }
        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;

        return merge(sortList(head), sortList(head2));
    }

    public static void main(String[] args) {
        ListNode dummy = new ListNode(-1);
        int[] nums = {4,10,-3,1,5 ,8,5,15};
        ListNode p = dummy;
        for (int n : nums) {
            p = p.next = new ListNode(n);
        }

        p = new Solution().sortList(dummy.next);
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }
}

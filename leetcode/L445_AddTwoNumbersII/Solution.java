package leetcode.L445_AddTwoNumbersII;

/**
 * @author: deadend
 * @date: 4:05 PM 12/23/16
 * @version: 1.0
 * @description:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    private int getLength(ListNode l) {
        int len = 0;
        while (l != null) {
            len++;
            l = l.next;
        }
        return len;
    }

    private ListNode helper(ListNode l1, ListNode l2, int delta) {
        if (l1 == null && l2 == null) {
            return new ListNode(0);
        }

        ListNode next = helper(l1.next, delta > 0 ? l2 : l2.next, delta > 0 ? delta - 1 : 0);
        next.val += l1.val + (delta > 0 ? 0 : l2.val);
        ListNode curr = new ListNode(next.val / 10);
        next.val %= 10;
        curr.next = next;
        return curr;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = getLength(l1);
        int len2 = getLength(l2);

        ListNode l;
        if (len1 >= len2) {
            l = helper(l1, l2, len1 - len2);
        } else {
            l = helper(l2, l1, len2 - len1);
        }
        return l.val == 0 ? l.next : l;
    }
}

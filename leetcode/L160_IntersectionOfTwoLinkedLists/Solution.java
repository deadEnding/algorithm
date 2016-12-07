package leetcode.L160_IntersectionOfTwoLinkedLists;

/**
 * @author: deadend
 * @date: 3:44 PM 12/7/16
 * @version: 1.0
 * @description:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    private int getLength(ListNode list) {
        int len = 0;
        while (list != null) {
            len++;
            list = list.next;
        }
        return len;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int m = getLength(headA);
        int n = getLength(headB);

        if (m > n) {
            ListNode tmp = headA;
            headA = headB;
            headB = tmp;
        }

        for (int i = 0; i < Math.abs(n - m); i++) {
            headB = headB.next;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}


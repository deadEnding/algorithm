package leetcode.L160_IntersectionOfTwoLinkedLists;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
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

    private ListNode runStep(ListNode head, int steps) {
        while (steps-- > 0) {
            head = head.next;
        }
        return head;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = getLength(headA);
        int l2 = getLength(headB);

        headA = runStep(headA, Math.max(0, l1 - l2));
        headB = runStep(headB, Math.max(0, l2 - l1));
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }
}

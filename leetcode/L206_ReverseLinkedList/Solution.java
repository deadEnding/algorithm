package leetcode.L206_ReverseLinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        while (head != null) {
            ListNode p = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = p;
        }
        return dummy.next;
    }
}

package leetcode.L237_DeleteNodeInALinkedList;

/**
 * @author: deadend
 * @date: 11:14 PM 12/P10/16
 * @version: 1.0
 * @description:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

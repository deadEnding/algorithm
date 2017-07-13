package leetcode.again.L023_MergeKSortedLists;

import java.util.PriorityQueue;

/**
 * @author: deadend
 * @date: 9:01 PM 3/17/17
 * @version: 1.0
 * @description:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((l1, l2) -> (l1.val - l2.val));
        for (ListNode list : lists) {
            if (list != null) {
                heap.offer(list);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            p.next = node;
            p = node;
            if (node.next != null) {
                heap.offer(node.next);
            }
        }
        return dummy.next;
    }
}

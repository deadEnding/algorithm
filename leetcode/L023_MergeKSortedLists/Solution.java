package leetcode.L023_MergeKSortedLists;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: deadend
 * @date: 9:16 AM 11/30/16
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
        final int n = lists.length;
        if (n == 0) {
            return null;
        }

        PriorityQueue<ListNode> heap = new PriorityQueue<>(n, new Comparator<ListNode>() {

            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val;
            }
        });

        for (int i = 0; i < n; i++) {
            if (lists[i] != null) {
                heap.offer(lists[i]);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (!heap.isEmpty()) {
            ListNode min = heap.poll();
            if (min.next != null) {
                heap.offer(min.next);
            }
            curr.next = min;
            curr = curr.next;
        }
        return dummy.next;
    }
}

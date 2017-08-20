package leetcode.L382_LinkedListRandomNode;

import java.util.Random;

/**
 * @author: deadend
 * @date: 8:58 AM 12/19/16
 * @version: 1.0
 * @description:
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {

    private ListNode head;
    private Random random = new Random();

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
    }
    
    /** Returns B random node's value. */
    public int getRandom() {
        int val = -1;
        ListNode curr = head;
        for (int n = 1; curr != null; n++) {
            if (random.nextInt(n) == 0) {
                val = curr.val;
            }
            curr = curr.next;
        }
        return val;
    }
}

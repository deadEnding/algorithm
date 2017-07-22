package leetcode.L138_CopyListWithRandomPointer;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: 7:P10 PM 3/16/17
 * @version: 1.0
 * @description:
 */

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
}


public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode dummy = new RandomListNode(-1);
        dummy.next = head;
        for (RandomListNode p = dummy; p.next != null; p = p.next.next) {
            RandomListNode q = new RandomListNode(p.next.label);
            q.next = p.next.next;
            p.next.next = q;
        }

        for (RandomListNode p = dummy.next; p != null; p = p.next.next) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
        }

        for (RandomListNode p = dummy, q = head; q != null; p = p.next, q = q.next) {
            p.next = q.next;
            q.next = q.next.next;
        }

        return dummy;
    }
}


class FirstSolution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode dummy = new RandomListNode(-1);
        dummy.next = head;
        for (RandomListNode p = dummy; p.next != null; p = p.next.next) {
            RandomListNode cp = new RandomListNode(p.next.label);
            cp.next = p.next.next;
            p.next.next = cp;
        }

        for (RandomListNode p = dummy.next; p != null; p = p.next.next) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
        }

        for (RandomListNode p = head, q = dummy; p != null; p = p.next, q = q.next) {
            q.next = p.next;
            p.next = p.next.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(-1);
        RandomListNode newHead = new Solution().copyRandomList(head);
        System.out.println(newHead.label);
    }
}

class BasicSolution {
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dummy1 = new RandomListNode(-1);
        dummy1.next = head;
        RandomListNode dummy2 = new RandomListNode(-1);
        for (RandomListNode p = dummy1, q = dummy2; p.next != null; p = p.next, q = q.next) {
            q.next = new RandomListNode(p.next.label);
            map.put(p.next, q.next);
        }

        for (RandomListNode p = dummy1.next; p != null; p = p.next) {
            map.get(p).random = map.get(p.random);
        }

        return dummy2.next;
    }
}

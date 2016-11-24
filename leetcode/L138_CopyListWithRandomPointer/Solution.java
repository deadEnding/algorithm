package leetcode.L138_CopyListWithRandomPointer;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: 8:44 PM 11/24/16
 * @version: 1.0
 * @description:
 */

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
};


public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        HashMap<RandomListNode, RandomListNode> randomMap = new HashMap<>();
        HashMap<RandomListNode, RandomListNode> onMap = new HashMap<>();
        RandomListNode newHead = new RandomListNode(head.label);

        RandomListNode older = head.next, newer = newHead;
        randomMap.put(head, head.random);
        onMap.put(head, newHead);
        while (older != null) {
            newer.next = new RandomListNode(older.label);
            randomMap.put(older, older.random);
            onMap.put(older, newer.next);
            newer = newer.next;
            older = older.next;
        }

        for (older = head; older != null; older = older.next) {
            onMap.get(older).random = onMap.get(randomMap.get(older));
        }
        return newHead;
    }

    public static void main(String[] args) {
        RandomListNode n0 = new RandomListNode(0);
        n0.random = n0;
        RandomListNode newHead = new Solution().copyRandomList(n0);
        while (newHead != null) {
            System.out.println(newHead.label + " " + (newHead.random == null ? "null" : newHead.random.label));
            newHead = newHead.next;
        }
    }
}

package leetcode.L225_ImplementStackUsingQueues;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 10:38 AM 12/10/16
 * @version: 1.0
 * @description:
 */


class MyStack {
    // Push element x onto stack.
    private LinkedList<Integer> queue = new LinkedList<>();
    private LinkedList<Integer> assistantQueue = new LinkedList<>();

    public void push(int x) {
        while (!queue.isEmpty()) {
            assistantQueue.offer(queue.poll());
        }
        queue.offer(x);
        while (!assistantQueue.isEmpty()) {
            queue.offer(assistantQueue.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.poll();
    }

    // Get the top element.
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}

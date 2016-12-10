package leetcode.L232_ImplementQueueUsingStacks;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 11:02 AM 12/10/16
 * @version: 1.0
 * @description:
 */


class MyQueue {
    private LinkedList<Integer> stack = new LinkedList<>();
    private LinkedList<Integer> assistantStack = new LinkedList<>();
    
    // Push element x to the back of queue.
    public void push(int x) {
        while (!stack.isEmpty()) {
            assistantStack.push(stack.pop());
        }
        assistantStack.push(x);
        while (!assistantStack.isEmpty()) {
            stack.push(assistantStack.pop());
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        stack.pop();
    }

    // Get the front element.
    public int peek() {
        return stack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.isEmpty();
    }
}

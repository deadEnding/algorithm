package leetcode.L232_ImplementQueueUsingStacks;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 11:02 AM 12/P10/16
 * @version: 1.0
 * @description:
 */

public class MyQueue {

    private LinkedList<Integer> stackNewest = new LinkedList<>();
    private LinkedList<Integer> stackOldest = new LinkedList<>();

    // Push element x to the back of queue.
    public void push(int x) {
        stackNewest.push(x);
    }

    private void checkToFlush() {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        checkToFlush();
        stackOldest.pop();
    }

    // Get the front element.
    public int peek() {
        checkToFlush();
        return stackOldest.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stackOldest.isEmpty() && stackNewest.isEmpty();
    }
}












class MyQueue2 {
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

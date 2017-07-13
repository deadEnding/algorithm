package leetcode.again.L232_ImplementQueueUsingStacks;


import java.util.LinkedList;

public class MyQueue {

    private LinkedList<Integer> stack0;
    private LinkedList<Integer> stack1;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack0 = new LinkedList<>();
        stack1 = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack0.push(x);
    }

    private void check() {
        if (stack1.isEmpty()) {
            while (!stack0.isEmpty()) {
                stack1.push(stack0.pop());
            }
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        check();
        return stack1.pop();
    }

    /** Get the front element. */
    public int peek() {
        check();
        return stack1.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack0.isEmpty() && stack1.isEmpty();
    }
}


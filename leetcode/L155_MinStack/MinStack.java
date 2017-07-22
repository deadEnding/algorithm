package leetcode.again.L155_MinStack;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 5:25 PM 3/16/17
 * @version: 1.0
 * @description:
 */


public class MinStack {

    private long min;
    private LinkedList<Long> stack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = x;
        } else {
            stack.push(x - min);
            min = Math.min(min, x);
        }
    }

    public void pop() {
        long t = stack.pop();
        if (t < 0) {
            min = min - t;
        }
    }

    public int top() {
        if (stack.peek() < 0) {
            return (int) min;
        } else {
            return (int) (stack.peek() + min);
        }
    }

    public int getMin() {
        return (int) min;
    }
}


class SingleMinStack {

    private int min = Integer.MAX_VALUE;
    private LinkedList<Integer> stack;

    /** initialize your data structure here. */
    public SingleMinStack() {
        stack = new LinkedList<>();
    }

    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}


class BasicMinStack {

    private LinkedList<Integer> stack;
    private LinkedList<Integer> assistStack;

    /** initialize your data structure here. */
    public BasicMinStack() {
        stack = new LinkedList<>();
        assistStack = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
        if (assistStack.isEmpty() || x <= assistStack.peek()) {
            assistStack.push(x);
        }
    }

    public void pop() {
        if ((int) stack.pop() == assistStack.peek()) {
            assistStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return assistStack.peek();
    }
}

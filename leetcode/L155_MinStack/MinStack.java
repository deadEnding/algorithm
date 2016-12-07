package leetcode.L155_MinStack;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 3:31 PM 12/7/16
 * @version: 1.0
 * @description:
 */


public class MinStack {

    private LinkedList<Integer> stack;
    private LinkedList<Integer> mins;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        mins  = new LinkedList<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (mins.isEmpty() || mins.peek() >= x) {
            mins.push(x);
        }
    }
    
    public void pop() {
        int t = stack.pop();
        if (t == mins.peek()) {
            mins.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return mins.peek();
    }
}


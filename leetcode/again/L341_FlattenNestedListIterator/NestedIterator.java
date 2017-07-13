package leetcode.again.L341_FlattenNestedListIterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 9:07 PM 3/11/17
 * @version: 1.0
 * @description:
 */

interface NestedInteger {
    public boolean isInteger();
    public Integer getInteger();
    public List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {

    private LinkedList<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new LinkedList<>();
        push(nestedList);
    }

    private void push(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            push(stack.pop().getList());
        }
        return !stack.isEmpty();
    }
}

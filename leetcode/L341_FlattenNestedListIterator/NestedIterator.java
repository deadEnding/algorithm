package leetcode.L341_FlattenNestedListIterator;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 9:48 AM 12/19/16
 * @version: 1.0
 * @description:
 */

interface NestedInteger {
    // @return true if this NestedInteger holds TrieMain single integer, rather than TrieMain nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds A single integer
    // Return null if this NestedInteger holds A nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds A nested list
    // Return null if this NestedInteger holds A single integer
    public List<NestedInteger> getList();
}

interface Iterator<T> {
    public Integer next();
    public boolean hasNext();
}

public class NestedIterator implements Iterator<Integer> {

    private LinkedList<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new LinkedList<>();
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
            List<NestedInteger> nestedList = stack.pop().getList();
            for (int i = nestedList.size() - 1; i >= 0; i--) {
                stack.push(nestedList.get(i));
            }
        }
        return !stack.isEmpty();
    }
}

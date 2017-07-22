package leetcode.again.L284_PeekingIterator;

import java.util.Iterator;

/**
 * @author: deadend
 * @date: 6:56 PM 3/15/17
 * @version: 1.0
 * @description:
 */

class PeekingIterator implements Iterator<Integer> {

    private Integer cache;
    private Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        if (iterator.hasNext()) {
            cache = iterator.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return cache;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer tmp = cache;
        cache = iterator.hasNext() ? iterator.next() : null;
        return tmp;
    }

    @Override
    public boolean hasNext() {
        return cache != null;
    }
}


class BasicPeekingIterator implements Iterator<Integer> {

    private Integer cache;
    private Iterator<Integer> iterator;

    public BasicPeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (cache == null) {
            cache = iterator.next();
        }
        return cache;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (cache == null) {
            return iterator.next();
        }

        Integer t = cache;
        cache = iterator.hasNext() ? iterator.next() : null;
        return t;
    }

    @Override
    public boolean hasNext() {
        return cache != null || iterator.hasNext();
    }
}

package leetcode.L284_PeekingIterator;

/**
 * @author: deadend
 * @date: 7:19 PM 12/11/16
 * @version: 1.0
 * @description:
 */

interface Iterator<T> {
    boolean hasNext();
    T next();
}


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
        int tmp = cache;
        if (iterator.hasNext()) {
            cache = iterator.next();
        } else {
            cache = null;
        }
        return tmp;
    }

    @Override
    public boolean hasNext() {
        return cache != null;
    }
}
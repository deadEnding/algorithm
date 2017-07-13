package leetcode.again.L281_ZigzagIterator;

import java.util.Iterator;
import java.util.List;

/**
 * @author: deadend
 * @date: P10:33 AM 3/P10/17
 * @version: 1.0
 * @description:
 */


public class ZigzagIterator {

    private int ix;
    private Iterator<Integer>[] it = new Iterator[2];

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        it[0] = v1.iterator();
        it[1] = v2.iterator();
    }

    public int next() {
        if (it[ix % 2].hasNext()) {
            return it[ix++ % 2].next();
        } else {
            ix++;
        }
        return it[ix++ % 2].next();
    }

    public boolean hasNext() {
        for (Iterator<Integer> i : it) {
            if (i.hasNext()) {
                return true;
            }
        }
        return false;
    }
}

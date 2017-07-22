package leetcode.L251_Flatten2dVector;

import java.util.Iterator;
import java.util.List;

/**
 * @author: deadend
 * @date: 8:58 PM 3/12/17
 * @version: 1.0
 * @description:
 */


public class Vector2D implements Iterator<Integer> {

    private Iterator<Integer> innerIter;
    private Iterator<List<Integer>> outerIter;

    public Vector2D(List<List<Integer>> vec2d) {
        outerIter = vec2d.iterator();
    }

    @Override
    public Integer next() {
        return innerIter.next();
    }

    @Override
    public boolean hasNext() {
        while ((innerIter == null || !innerIter.hasNext()) && outerIter.hasNext()) {
            innerIter = outerIter.next().iterator();
        }
        return innerIter != null && innerIter.hasNext();
    }
}

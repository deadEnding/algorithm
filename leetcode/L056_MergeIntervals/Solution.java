package leetcode.again.L056_MergeIntervals;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 12:25 PM 3/3/17
 * @version: 1.0
 * @description:
 */

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}


public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 2)
            return intervals;

        Collections.sort(intervals, (i1, i2) -> (i1.start - i2.start));
        List<Interval> result = new LinkedList<>();
        Interval intvl = null;
        for (Interval i : intervals) {
            if (intvl == null) {
                intvl = new Interval(i.start, i.end);
            } else {
                if (intvl.end >= i.start) {
                    intvl.end = Math.max(intvl.end, i.end);
                } else {
                    result.add(intvl);
                    intvl = new Interval(i.start, i.end);
                }
            }
        }
        result.add(intvl);
        return result;
    }
}

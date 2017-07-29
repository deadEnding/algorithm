package leetcode.L056_MergeIntervals;

import java.util.*;

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
        List<Interval> merged = new LinkedList<>();
        if (intervals.isEmpty()) {
            return merged;
        }

        Collections.sort(intervals, (i1, i2) -> (i1.start - i2.start));
        Interval itv = new Interval(intervals.get(0).start, intervals.get(0).end);
        for (int i = 1; i <= intervals.size(); i++) {
            if (i == intervals.size() || intervals.get(i).start > itv.end) {
                merged.add(itv);
                if (i != intervals.size()) {
                    itv = new Interval(intervals.get(i).start, intervals.get(i).end);
                }
            } else {
                itv.end = Math.max(itv.end, intervals.get(i).end);
            }
        }

        return merged;
    }
}


class OldSolution {
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

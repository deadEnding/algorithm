package leetcode.L056_MergeIntervals;

import java.util.*;

/**
 * @author: deadend
 * @date: 8:45 AM 11/17/16
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
        if (intervals.size() <= 1) {
            return intervals;
        }
        Collections.sort(intervals, (i1, i2) -> (i1.start != i2.start ? i1.start - i2.start : i1.end - i2.end));

        List<Interval> result = new ArrayList<>();
        result.add(intervals.get(0));
        Interval last = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval p = intervals.get(i);
            if (p.start > last.end) {
                result.add(p);
                last = p;
            } else {
                last.end = Math.max(last.end, p.end);
            }
        }
        return result;
    }
}


class FirstSolution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        List<Interval> result = new LinkedList<>();
        boolean ended = true;
        for (Interval interval : intervals) {
            if (ended) {
                result.add(new Interval(interval.start, interval.end));
                ended = false;
            } else {
                Interval last = result.get(result.size() - 1);
                if (last.end < interval.start) {
                    result.add(new Interval(interval.start, interval.end));
                } else {
                    last.end = Math.max(last.end, interval.end);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new LinkedList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));
        List<Interval> result = new Solution().merge(intervals);
        for (Interval interval : result) {
            System.out.println(interval.start + " " + interval.end);
        }
    }
}

package leetcode.L057_InsertInteval;

import java.util.*;

/**
 * @author: deadend
 * @date: 8:47 AM 11/17/16
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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
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
        intervals.add(new Interval(1, 5));
        List<Interval> result = new Solution().insert(intervals, new Interval(4,6));
        for (Interval interval : result) {
            System.out.println(interval.start + " " + interval.end);
        }

    }
}

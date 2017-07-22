package leetcode.again.L057_InsertInterval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }

    public String toString() {
        return start + "," + end;
    }
}


public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int ix = Collections.binarySearch(intervals, newInterval, (i1, i2) -> (i1.start - i2.start));
        int n = ix < 0 ? -(ix + 1) : ix;

        List<Interval> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(intervals.get(i));
        }

        Interval last = null;
        if (ix >= 0 || ix == -1) {
            result.add(newInterval);
        } else {
            last = result.get(result.size() - 1);
            if (newInterval.start > last.end) {
                result.add(newInterval);
            } else {
                last.end = Math.max(last.end, newInterval.end);
            }
        }
        System.out.println(result);

        last = result.get(result.size() - 1);
        for (int i = n; i < intervals.size(); i++) {
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

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 5));
        List<Interval> result = new Solution().insert(intervals, new Interval(0, 3));
        for (Interval interval : result) {
            System.out.println(interval.start + " " + interval.end);
        }
    }
}

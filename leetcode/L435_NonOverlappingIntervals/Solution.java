package leetcode.L435_NonOverlappingIntervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author: deadend
 * @date: 9:49 PM 12/22/16
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
    public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.end - i2.end;
            }
        });

        int count = 0;
        for (int i = 0, end = Integer.MIN_VALUE; i < intervals.length; i++) {
            if (end <= intervals[i].start) {
                count++;
                end = intervals[i].end;
            }
        }
        return intervals.length - count;
    }
}

class TimeoutSolution {
    private int helper(Interval[] intervals, int ix, int minstart, HashMap<Integer, Integer> mem) {
        if (ix == intervals.length) {
            return 0;
        }

        int max = helper(intervals, ix + 1, minstart, mem);
        if (intervals[ix].start >= minstart) {
            if (!mem.containsKey(ix)) {
                int used = helper(intervals, ix + 1, intervals[ix].end, mem) + 1;
                mem.put(ix, used);
            }
            max = Math.max(max, mem.get(ix));
        }
        return max;
    }

    public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start != i2.start ? i1.start - i2.start : i1.end - i2.end;
            }
        });
        return intervals.length - helper(intervals, 0, Integer.MIN_VALUE, new HashMap<Integer, Integer>());
    }
}

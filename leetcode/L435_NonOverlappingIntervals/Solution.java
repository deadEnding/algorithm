package leetcode.L435_NonOverlappingIntervals;

import java.util.Arrays;

/**
 * @author: deadend
 * @date: 6:53 PM 3/1/17
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
        Arrays.sort(intervals, (i1, i2) -> (i1.end - i2.end));
        int count = 0;
        for (int i = 0, end = Integer.MIN_VALUE; i < intervals.length; i++) {
            if (intervals[i].start >= end) {
                count++;
                end = intervals[i].end;
            }
        }
        return intervals.length - count;
    }
}

package leetcode.again.L436_FindRightInterval;

import java.util.TreeMap;

/**
 * @author: deadend
 * @date: 7:08 PM 3/1/17
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
    public int[] findRightInterval(Interval[] intervals) {
        final int n = intervals.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.put(intervals[i].start, i);
        }

        int[] index = new int[n];
        for (int i = 0; i < n; i++) {
            Integer key = map.ceilingKey(intervals[i].end);
            index[i] = key == null ? -1 : map.get(key);
        }
        return index;
    }
}



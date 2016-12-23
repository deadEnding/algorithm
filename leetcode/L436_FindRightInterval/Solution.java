package leetcode.L436_FindRightInterval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author: deadend
 * @date: 10:23 AM 12/23/16
 * @version: 1.0
 * @description:
 */

class Interval {
    public int start;
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
            Map.Entry<Integer, Integer> e = map.ceilingEntry(intervals[i].end);
            index[i] = e != null ? e.getValue() : -1;
        }
        return index;
    }
}

class SortAndBinarySearchSolution {
    private int binarySearch(int[][] starts, int target) {
        int l = 0, r = starts.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (starts[mid][0] == target) {
                return mid;
            } else if(starts[mid][0] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public int[] findRightInterval(Interval[] intervals) {
        final int n = intervals.length;
        int[][] starts = new int[n][2];
        for (int i = 0; i < n; i++) {
            starts[i][0] = intervals[i].start;
            starts[i][1] = i;
        }
        Arrays.sort(starts, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[] index = new int[n];
        for (int i = 0; i < n; i++) {
            int ix = binarySearch(starts, intervals[i].end);
            index[i] = ix < n ? starts[ix][1] : -1;
        }
        return index;
    }
}

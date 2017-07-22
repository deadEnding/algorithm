package leetcode.L252_MeetingRooms;

import java.util.Arrays;

/**
 * @author: deadend
 * @date: 2:04 PM 3/12/17
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
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, (i1, i2) -> (i1.start - i2.start));
        for (int i = 0, s = Integer.MIN_VALUE; i < intervals.length; i++) {
            if (intervals[i].start >= s) {
                s = intervals[i].end;
            } else {
                return false;
            }
        }
        return true;
    }
}

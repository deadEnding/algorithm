package leetcode.again.L253_MeetingRoomsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: deadend
 * @date: 1:33 PM 3/12/17
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

    private int minMeetingRooms(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return 0;
        }

        ArrayList<Interval> next = new ArrayList<>();
        for (int i = 0, s = Integer.MIN_VALUE; i < intervals.size(); i++) {
            if (intervals.get(i).start >= s) {
                s = intervals.get(i).end;
            } else {
                next.add(intervals.get(i));
            }
        }
        return minMeetingRooms(next) + 1;
    }

    public int minMeetingRooms(Interval[] intervals) {
        List<Interval> list = Arrays.asList(intervals);
        Collections.sort(list, (i1, i2) -> (i1.start != i2.start ? i1.start - i2.start : i1.end - i2.end));
        return minMeetingRooms(list);
    }
}

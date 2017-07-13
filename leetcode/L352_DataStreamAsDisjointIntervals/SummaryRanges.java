package leetcode.L352_DataStreamAsDisjointIntervals;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author: deadend
 * @date: 2:06 PM 2/17/17
 * @version: 1.0
 * @description:
 */

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
    public String toString() {
        return "[" + start + "," + end + "]";
    }
}

public class SummaryRanges {

    private TreeMap<Integer, Interval> map;

    public SummaryRanges() {
        map = new TreeMap<>();
    }

    public void addNum(int val) {
        Integer l = map.floorKey(val);
        Integer r = map.ceilingKey(val);
        if (l != null && r != null && map.get(l).end + 1 == val && r == val + 1) {
            map.get(l).end = map.remove(r).end;
        } else if (l != null && map.get(l).end + 1 >= val) {
            if (map.get(l).end + 1 == val) {
                map.get(l).end = val;
            }
        } else if (r != null && r == val + 1) {
            map.put(val, new Interval(val, map.remove(r).end));
        } else {
            map.put(val, new Interval(val, val));
        }
    }

    public List<Interval> getIntervals() {
        List<Interval> intervals = new LinkedList<>();
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            intervals.add(map.get(iterator.next()));
        }
        return intervals;
    }

    public static void main(String[] args) {
        SummaryRanges summaryRanges = new SummaryRanges();
        int[] nums = {1,3,7,2,6};
        for (int n : nums) {
            summaryRanges.addNum(n);
            System.out.println(summaryRanges.getIntervals());
        }
    }
}

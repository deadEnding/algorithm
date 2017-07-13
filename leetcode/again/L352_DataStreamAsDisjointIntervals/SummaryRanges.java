package leetcode.again.L352_DataStreamAsDisjointIntervals;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author: deadend
 * @date: 2:26 PM 3/3/17
 * @version: 1.0
 * @description:
 */

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}


public class SummaryRanges {

    TreeMap<Integer, Integer> map;

    public SummaryRanges() {
        map = new TreeMap<>();
    }

    public void addNum(int val) {
        Integer left = map.floorKey(val);
        Integer right = map.ceilingKey(val);
        if (left == null && right == null) {
            map.put(val, val);
        } else if (left == null) {
            if (right == val + 1) {
                map.put(val, map.remove(right));
            } else {
                map.put(val, val);
            }
        } else if (right == null) {
            int t = map.get(left);
            if (t == val - 1) {
                map.put(left, val);
            } else if (t < val - 1) {
                map.put(val, val);
            }
        } else {
            int lend = map.get(left);
            if (lend < val - 1) {
                if (right == val + 1) {
                    map.put(val, map.remove(right));
                } else {
                    map.put(val, val);
                }
            } else if (lend == val - 1) {
                if (right == val + 1) {
                    map.put(left, map.remove(right));
                } else {
                    map.put(left, val);
                }
            }
        }
    }

    public List<Interval> getIntervals() {
        List<Interval> result = new LinkedList<>();
        for (int key : map.keySet()) {
            result.add(new Interval(key, map.get(key)));
        }
        return result;
    }
}

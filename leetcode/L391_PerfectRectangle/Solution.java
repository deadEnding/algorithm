package leetcode.again.L391_PerfectRectangle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author: deadend
 * @date: 1:43 PM 3/14/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    private String hash(int x, int y) {
        return x + "|" + y;
    }
    private List<String> getPoints(int[] r) {
        List<String> ps = new ArrayList<>(4);
        ps.add(hash(r[0], r[1]));
        ps.add(hash(r[0], r[3]));
        ps.add(hash(r[2], r[3]));
        ps.add(hash(r[2], r[1]));
        return ps;
    }

    public boolean isRectangleCover(int[][] rectangles) {
        long area = 0;
        int top = Integer.MIN_VALUE, bottom = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;

        HashSet<String> set = new HashSet<>();
        for (int[] r : rectangles) {
            top = Math.max(top, r[3]);
            right = Math.max(right, r[2]);
            bottom = Math.min(bottom, r[1]);
            left = Math.min(left, r[0]);
            area += ((long) r[3] - r[1]) * (r[2] - r[0]);
            for (String s : getPoints(r)) {
                if (set.contains(s)) {
                    set.remove(s);
                } else {
                    set.add(s);
                }
            }
        }

        if (set.size() != 4 || ((long) top - bottom) * (right - left) != area) {
            return false;
        }

        return set.contains(hash(left, bottom)) && set.contains(hash(left,top)) &&
                set.contains(hash(right, bottom)) && set.contains(hash(right, top));
    }
}

package leetcode.L391_PerfectRectangle;

import java.util.HashSet;

/**
 * @author: deadend
 * @date: 7:09 PM 12/19/16
 * @version: 1.0
 * @description:
 */

public class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int x1, x2, y1, y2;
        int area = 0;
        x1 = y1 = Integer.MAX_VALUE;
        x2 = y2 = Integer.MIN_VALUE;

        HashSet<String> set = new HashSet<>();

        for (int[] p : rectangles) {
            x1 = Math.min(x1, p[0]);
            y1 = Math.min(y1, p[1]);
            x2 = Math.max(x2, p[2]);
            y2 = Math.max(y2, p[3]);

            area += (p[2] - p[0]) * (p[3] - p[1]);

            String s1 = p[0] + " " + p[1];
            String s2 = p[0] + " " + p[3];
            String s3 = p[2] + " " + p[3];
            String s4 = p[2] + " " + p[1];

            if (!set.add(s1)) { set.remove(s1); }
            if (!set.add(s2)) { set.remove(s2); }
            if (!set.add(s3)) { set.remove(s3); }
            if (!set.add(s4)) { set.remove(s4); }
        }

        if (!set.contains(x1 + " " + y1) || !set.contains(x1 + " " + y2) || !set.contains(x2 + " " + y1)
                || !set.contains(x2 + " " + y2) || set.size() != 4) {
            return false;
        }

        return area == (x2 - x1) * (y2 - y1);
    }
}

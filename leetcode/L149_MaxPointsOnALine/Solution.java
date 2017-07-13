package leetcode.L149_MaxPointsOnALine;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: 12:36 PM 2/15/17
 * @version: 1.0
 * @description:
 */

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}

public class Solution {

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    private String simplify(long a, long b) {
        long g = gcd(a, b);
        return a / g + "/" + b / g;
    }

    public int maxPoints(Point[] points) {
        final int n = points.length;
        if (n <= 2) {
            return n;
        }

        int max = 1;
        for (int i = 0; i < n; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            int kmax = 0;
            int infiniteCount = 0;
            int dump = 1;
            for (int j = i + 1; j < n; j++) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    dump++;
                    continue;
                }

                if (points[i].x == points[j].x) {
                    infiniteCount++;
                } else {
                    String k = simplify((long) points[i].y - points[j].y, (long) points[i].x - points[j].x);
                    map.put(k, map.getOrDefault(k, 0) + 1);
                    kmax = Math.max(kmax, map.get(k));
                }
            }
            max = Math.max(max, Math.max(kmax, infiniteCount) + dump);
        }
        return max;
    }
}


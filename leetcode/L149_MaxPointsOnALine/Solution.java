package leetcode.again.L149_MaxPointsOnALine;


import java.util.HashMap;

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}

public class Solution {

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private String simplify(long a, long b) {
        long c = gcd(a, b);
        return (a / c) + "/" + (b / c);
    }

    public int maxPoints(Point[] points) {
        final int n = points.length;
        if (n <= 2) {
            return n;
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            int inf = 1;
            int dup = 0;
            HashMap<String, Integer> map = new HashMap<>();
            int tmax = 0;
            for (int j = i + 1; j < n; j++) {
                if (points[i].x == points[j].x) {
                    if (points[i].y == points[j].y)
                        dup++;
                    else
                        inf++;
                } else {
                    String k = simplify((long) points[j].y - points[i].y, (long) points[j].x - points[i].x);
                    map.put(k, map.getOrDefault(k, 1) + 1);
                    tmax = Math.max(tmax, map.get(k));
                }
            }

            max = Math.max(max, Math.max(inf, tmax) + dup);
        }

        return max;
    }
}

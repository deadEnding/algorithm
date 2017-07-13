package custom.company.hulu.others;

import java.util.Arrays;
import java.util.Comparator;

//class Interval {
//    int start, end;
//    boolean startInclusive, endIncliusive;
//    Interval(int s, int e, boolean si, boolean ei) {
//        start = s;
//        end = e;
//        startInclusive = si;
//        endIncliusive = ei;
//    }
//}

class Point {
    int x;
    boolean inclusive;
    boolean isStart;
    public Point(int x, boolean inclusive, boolean isStart) {
        this.x = x;
        this.inclusive = inclusive;
        this.isStart = isStart;
    }
}

public class MaxIntersectionNum {

    public int solve(int[] y) {
        final int n = y.length;

        for (int i = 1; i < n; i++) {
            if (y[i - 1] == y[i]) {
                return y[i];
            }
        }

        Point[] points = new Point[2* n - 2];
        for (int i = 0; i < n - 1; i++) {
            int min = Math.min(y[i + 1], y[i]);
            int max = Math.max(y[i + 1], y[i]);
            boolean inclusive = i % 2 == 0;
            points[2 * i] = new Point(min, inclusive, true);
            points[2 * i + 1] = new Point(max, inclusive, false);
            if (i == n - 2) {
                if (y[i + 1] < y[i]) {
                    points[2 * i].inclusive = true;
                } else {  // >
                    points[2 * i + 1].inclusive = true;
                }
            }
        }

        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
//                if (p1.x != p2.x) {
//                    return p1.x - p2.x;
//                }
//
//                if (p1.isStart == p2.isStart && p1.isStart == true) {
//                    if (p1.inclusive != p2.inclusive) {  // inclusive为true的在前
//                        return p1.inclusive ? -1 : 1;
//                    }
//                    return 0;
//                } else if ()
//
//                if (p1.isStart != p2.isStart) {
//                    return p1.isStart ? 1 : -1;
//                }
                return 0;
            }
        });

        return helper(points);
    }

    public int helper(Point[] points) {
        final int n = points.length;

        int max = 0;
        int count = 0;
        for (Point p : points) {
            if (p.isStart) {
            } else {

            }
        }
        return 0;
    }
}

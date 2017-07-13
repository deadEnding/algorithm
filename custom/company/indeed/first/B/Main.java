package custom.company.indeed.first.B;

import java.util.Scanner;

public class Main {

    static class Point {
        long x;
        long y;
        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int n, t;
    private static long min;

    public static void dfs(int ix, Point[] prev, Point[] curr, boolean[] match, long dist) {
        if (ix == n) {
            min = Math.min(min, dist);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!match[i]) {
                long d = Math.abs(prev[ix].x - curr[i].x)+ Math.abs(prev[ix].y - curr[i].y);
                match[i] = true;
                dfs(ix + 1, prev, curr, match, dist + d);
                match[i] = false;
            }
        }
    }

    public static long solve(Point[][] ps) {
        long total = 0;
        for (int i = 1; i <= t; i++) {
            boolean[] match = new boolean[n];
            min = Long.MAX_VALUE;
            dfs(0, ps[i - 1], ps[i], match, 0L);
            total += min;
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = sc.nextInt();
        Point[][] points = new Point[t + 1][n];
        for (int i = 0; i <= t; i++) {
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                points[i][j] = new Point(x, y);
            }
        }
        System.out.println(solve(points));
    }
}

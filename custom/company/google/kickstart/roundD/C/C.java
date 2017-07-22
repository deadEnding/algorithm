package custom.company.google.kickstart.roundD.C;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class C {

    private static int n, p, h;
    private static int[][] pts;

    private static double EPS = 1e-9;

    private static double dist(double x1, double y1) {
        return  (x1 - pts[0][0]) * (x1 - pts[0][0]) + (y1 - pts[0][1]) * (y1 - pts[0][1]);
    }

    private static double minDist(double a) {
        double l = 0, r = p;
        while (l + EPS < r) {
            double x1 = l + (r - l) / 3;
            double x2 = r - (r - l) / 3;
            double y1 = a * x1 * (x1 - p);
            double y2 = a * x2 * (x2 - p);
            double d1 = dist(x1, y1);
            double d2 = dist(x2, y2);
            if (d1 < d2) {
                r = x2;
            } else {
                l = x1;
            }
        }

        return Math.sqrt(dist(l, a * l * (l - p)));
    }

    private static double distance(double a) {
        return Math.min(minDist(a), h + a * p * p / 4.0);
    }

    private static double search(double l, double r) {
        while (l + EPS < r) {
            double mid1 = l + (r - l) / 3;
            double mid2 = r - (r - l) / 3;
            double d1 = distance(mid1);
            double d2 = distance(mid2);
            if (d1 < d2) {
                l = mid1;
            } else {
                r = mid2;
            }
        }

        return distance(l);
    }

    private static double solveOne() {
        double a = (double) pts[0][1] / (pts[0][0] * (pts[0][0] - p));
//        return search(-4 * h / p / p, a);
        return Math.max(search(-4.0 * h / p / p, a), search(a, 0));
    }

    private static double solve() {
        return n == 1 ? solveOne() : 0;
    }

    public static void main(String[] args) throws FileNotFoundException {
//        FileInputStream fis = new FileInputStream("/Users/deadend/Downloads/C-small-attempt1.in");
//        PrintStream ps=new PrintStream(new FileOutputStream("/Users/deadend/Downloads/C-small.out"));
        FileInputStream fis = new FileInputStream("/Users/deadend/Downloads/C-large.in");
        PrintStream ps=new PrintStream(new FileOutputStream("/Users/deadend/Downloads/C-large.out"));
        System.setIn(fis);
        System.setOut(ps);

        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();

        for (int _c = 1; _c <= cases; _c++) {
            n = sc.nextInt();
            p = sc.nextInt();
            h = sc.nextInt();
            pts = new int[n][2];
            for (int i = 0; i < n; i++) {
                pts[i][0] = sc.nextInt();
                pts[i][1] = sc.nextInt();
            }
            System.out.println(String.format("Case #%d: %f", _c, solve()));
        }
    }
}

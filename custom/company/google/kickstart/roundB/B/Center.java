package custom.company.google.kickstart.roundB.B;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * 三分搜索求凹函数最小值
 */

public class Center {

    private static final double MIN = -1000;
    private static final double MAX = 1000;
    private static final double EPS = 1e-9;

    private static int n;
    private static double[][] p;

    private static double sum(double x, double y) {
        double s = 0;
        for (int i = 0; i < n; i++) {
            s += Math.max(Math.abs(p[i][0] - x), Math.abs(p[i][1] - y)) * p[i][2];
        }
        return s;
    }

    private static double triSearchInner(double x) {
        double down = MIN, up = MAX;
        while (down + EPS < up) {
            double mid1 = down + (up - down) / 3;
            double mid2 = up - (up - down) / 3;
            if (sum(x, mid1) < sum(x, mid2)) {
                up = mid2;
            } else {
                down = mid1;
            }
        }

        return sum(x, down);
    }

    private static double triSearchOuter() {
        double left = MIN, right = MAX;
        while (left + EPS < right) {
            double mid1 = left + (right - left) / 3;
            double mid2 = right - (right - left) / 3;
            if (triSearchInner(mid1) < triSearchInner(mid2)) {
                right = mid2;
            } else {
                left = mid1;
            }
        }

        return triSearchInner(left);
    }

    private static double solve() {
        return triSearchOuter();
    }

    public static void main(String[] args) throws FileNotFoundException {
//        FileInputStream fis = new FileInputStream("/Users/deadend/Downloads/B-small-practice1.in");
//        PrintStream ps=new PrintStream(new FileOutputStream("/Users/deadend/Downloads/B-small.out"));
        FileInputStream fis = new FileInputStream("/Users/deadend/Downloads/B-large-practice1.in");
        PrintStream ps=new PrintStream(new FileOutputStream("/Users/deadend/Downloads/B-large.out"));
        System.setIn(fis);
        System.setOut(ps);

        Scanner sc = new Scanner(System.in);
        int cases = Integer.valueOf(sc.nextLine());
        for (int c = 1; c <= cases; c++) {
            n = Integer.valueOf(sc.nextLine());
            p = new double[n][3];
            for (int i = 0; i < n; i++) {
                String[] xyw = sc.nextLine().split(" ");
                p[i][0] = Double.valueOf(xyw[0]);
                p[i][1] = Double.valueOf(xyw[1]);
                p[i][2] = Double.valueOf(xyw[2]);
            }

            System.out.println(String.format("Case #%d: %f", c, solve()));
        }
    }
}

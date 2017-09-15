package custom.company.google.kickstart.roundE.C;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.Scanner;

public class C {

    static class Point {
        int x, y, z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    private static Point p1, p2, p3;

    public static double solve() {
        double max = Math.max(p1.x, Math.max(p2.x, p3.x));
        double min = Math.min(p1.x, Math.min(p2.x, p3.x));
        return (max - min) / 6;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String base = "/Users/deadend/Downloads/";
        String input = "C-small-attempt0";
//        String input = "C-large";
        FileInputStream fis = new FileInputStream(base + input + ".in");
        PrintStream ps = new PrintStream(new FileOutputStream(base + input + ".out"));
        System.setIn(fis);
        System.setOut(ps);

        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();

        for (int _c = 1; _c <= cases; _c++) {
            p1 = new Point(sc.nextInt(), sc.nextInt(), sc.nextInt());
            p2 = new Point(sc.nextInt(), sc.nextInt(), sc.nextInt());
            p3 = new Point(sc.nextInt(), sc.nextInt(), sc.nextInt());
            DecimalFormat df = new DecimalFormat("0.0000000000");
            System.out.println(String.format("Case #%d: %s", _c, df.format(solve())));
        }
    }
}

package custom.company.google.kickstart.roundA.C;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: deadend
 * @date: 3:30 PM 3/5/17
 * @version: 1.0
 * @description:
 */


public class SpaceCubes {

    private static int min = Integer.MAX_VALUE;

    private static int getMinDist(int[] e) {
        int x = e[1] - e[0];
        int y = e[3] - e[2];
        int z = e[5] - e[4];
        return Math.max(z, Math.max(x, y));
    }

    private static void resolve(int ix, int[][] p, int[] e1,int[] e2) {
        if (ix == p.length) {
            min = Math.min(min, Math.min(getMinDist(e1), getMinDist(e2)));
            return;
        }

        int[] e1cp = Arrays.copyOf(e1, e1.length);
        e1cp[0] = Math.min(e1cp[0], p[ix][0] - p[ix][3]);
        e1cp[1] = Math.max(e1cp[1], p[ix][0] + p[ix][3]);
        e1cp[2] = Math.min(e1cp[2], p[ix][1] - p[ix][3]);
        e1cp[3] = Math.max(e1cp[3], p[ix][1] + p[ix][3]);
        e1cp[4] = Math.min(e1cp[4], p[ix][2] - p[ix][3]);
        e1cp[5] = Math.max(e1cp[5], p[ix][2] + p[ix][3]);
        resolve(ix + 1, p, e1cp, e2);

        int[] e2cp = Arrays.copyOf(e2, e2.length);
        e2cp[0] = Math.min(e2cp[0], p[ix][0] - p[ix][3]);
        e2cp[1] = Math.max(e2cp[1], p[ix][0] + p[ix][3]);
        e2cp[2] = Math.min(e2cp[2], p[ix][1] - p[ix][3]);
        e2cp[3] = Math.max(e2cp[3], p[ix][1] + p[ix][3]);
        e2cp[4] = Math.min(e2cp[4], p[ix][2] - p[ix][3]);
        e2cp[5] = Math.max(e2cp[5], p[ix][2] + p[ix][3]);
        resolve(ix + 1, p, e1, e2cp);
    }

    private static int resolve(int[][] p) {
        int[] e1 = {Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE};
        int[] e2 = {Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE};
        resolve(0, p, e1, e2);
        return min;
    }

    public static void main(String[] args) throws FileNotFoundException {
//        FileInputStream fis = new FileInputStream("/home/deadend/Downloads/B-large.in");
//        System.setIn(fis);
//
//        PrintStream ps=new PrintStream(new FileOutputStream("/home/deadend/Downloads/B-large.out"));
//        System.setOut(ps);

        Scanner sc = new Scanner(System.in);
        int cases = Integer.valueOf(sc.nextLine());
        for (int _c = 1; _c <= cases; _c++) {
            int n = sc.nextInt();
            int[][] p = new int[n][4];
            for (int i = 0; i < n; i++) {
                p[i][0] = sc.nextInt();
                p[i][1] = sc.nextInt();
                p[i][2] = sc.nextInt();
                p[i][3] = sc.nextInt();
            }
            min = Integer.MAX_VALUE;
            System.out.println("Case #" + _c + ": " + resolve(p));
        }
    }
}

package custom.company.google.kickstart.roundD.A;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class A {

    private static int n, ts, tf;
    private static long[][] sfd;

    private static long findEarlyest(long[] sfd, long earlyest) {
        if (earlyest <= sfd[0]) {
            return sfd[0];
        }

        if ((earlyest - sfd[0]) % sfd[1] == 0)
            return ((earlyest - sfd[0]) / sfd[1]) * sfd[1] + sfd[0];
        else
            return ((earlyest - sfd[0]) / sfd[1] + 1) * sfd[1] + sfd[0];
    }

    private static long findLatest(long[] sfd, long latest) {
        return ((latest - sfd[0]) / sfd[1]) * sfd[1] + sfd[0];
    }

    private static int solve() {
        long[] latest = new long[n - 1];
        long curLatest = tf;
        for (int i = n - 2; i >= 0; i--) {
            curLatest -= sfd[i][2];
            latest[i] = findLatest(sfd[i], curLatest);
        }

        for (int i = 0; i < n - 1; i++) {
            System.out.println(i+ "  "+ latest[i]);
        }


        int count = 0;
        long time = 0;
        for (int i = 0; i < n - 1; i++) {
//            System.out.println(i + "===" + findEarlyest(sfd[i], time + ts));
            if (findEarlyest(sfd[i], time + ts) <= latest[i]) {
                count++;
                time = findEarlyest(sfd[i], time + ts) + sfd[i][2];
            } else if (findEarlyest(sfd[i], time) <= latest[i]) {
                time = findEarlyest(sfd[i], time) + sfd[i][2];
            } else {
//                System.out.println(i + " " + time);
                return -1;
            }
        }

        return count;
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("/Users/deadend/Downloads/B-small-attempt1.in");
        PrintStream ps=new PrintStream(new FileOutputStream("/Users/deadend/Downloads/B-small.out"));
//        FileInputStream fis = new FileInputStream("/Users/deadend/Downloads/B-large.in");
//        PrintStream ps=new PrintStream(new FileOutputStream("/Users/deadend/Downloads/B-large.out"));
        System.setIn(fis);
        System.setOut(ps);

        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();

        for (int _c = 1; _c <= cases; _c++) {
            n = sc.nextInt();
            ts = sc.nextInt();
            tf = sc.nextInt();
            sfd = new long[n - 1][3];
            for (int i = 0; i < n - 1; i++) {
                sfd[i][0] = sc.nextInt();
                sfd[i][1] = sc.nextInt();
                sfd[i][2] = sc.nextInt();
            }

            int ret = solve();
            System.out.println(String.format("Case #%d: %s", _c, ret == -1 ? "IMPOSSIBLE" : String.valueOf(ret)));
        }
    }
}

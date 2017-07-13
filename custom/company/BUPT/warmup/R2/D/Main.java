package custom.company.BUPT.warmup.R2.D;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: deadend
 * @date: 3:14 PM 29/03/2017
 */


public class Main {

    private static boolean can(int m, int n, int[] h, int[] s) {
        double[] t = new double[n];
        for (int i = 0; i < n; i++) {
            if (m < h[i]) {
                return false;
            }
            t[i] = (double) (m - h[i]) / s[i];
        }

        Arrays.sort(t);
        for (int i = 0; i < n; i++) {
            if (t[i] < i) {
                return false;
            }
        }
        return true;
    }

    private static int resolve(int n, int[] h, int[] s) {
        int l = 0, r = 100100001;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (can(m, n, h, s)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int c = 0; c < cases; c++) {
            int n = sc.nextInt();
            int[] h = new int[n];
            for (int i = 0; i < n; i++) {
                h[i] = sc.nextInt();
            }

            int[] s = new int[n];
            for (int i = 0; i < n; i++) {
                s[i] = sc.nextInt();
            }

            System.out.println(resolve(n, h, s));
        }
    }
}

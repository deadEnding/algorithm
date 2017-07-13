package custom.company.microsoft.internship.Q201604.A;

import java.util.Scanner;

/**
 * @author: deadend
 * @date: 1:34 PM 30/03/2017
 */


public class Main {

    private static boolean fit(int p, int w, int h, int[] size, int s) {
        if (s > w || s > h) {
            return false;
        }

        int rows = h / s * p;
        int needRows = 0;
        for (int sz : size) {
            needRows += (int) Math.ceil((double)sz / (w / s));
        }
        return needRows <= rows;
    }

    private static int resolve(int p, int w, int h, int[] size) {
        int l = 1, r = Integer.MAX_VALUE;
        while (l < r) {
            int m = r - (r - l) / 2;
            if (fit(p, w, h, size, m)) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int c = 0; c < cases; c++) {
            int n = sc.nextInt();
            int p = sc.nextInt();
            int w = sc.nextInt();
            int h = sc.nextInt();
            int[] size = new int[n];
            for (int i = 0; i < n; i++) {
                size[i] = sc.nextInt();
            }
            System.out.println(resolve(p, w, h, size));
        }
    }
}

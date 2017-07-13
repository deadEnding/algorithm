package oj.zoj.Z3197_GoogleBook;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static int solve(int[][] x, int n) {
        Arrays.sort(x, new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2) {
                return (i1[0] != i2[0] ? i1[0] - i2[0] : i1[1] - i2[1]);
            }
        });

        int end = 1;
        int ix = 0;
        int count = 0;
        while (end <= n && ix < n) {
            int maxEnd = end;
            while (ix < n && x[ix][0] <= end) {
                maxEnd = Math.max(maxEnd, x[ix++][1]);
            }

            end = maxEnd + 1;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] x = new int[n][2];
            for (int i = 0; i < n; i++) {
                x[i][0] = sc.nextInt();
                x[i][1] = sc.nextInt();
            }
            System.out.println(solve(x, n));
        }
    }
}

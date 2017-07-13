package custom.company.jd.Q3;

import java.util.Scanner;

public class Main {

    public static boolean hit(int[][] itv, int x, int carIx) {
        return itv[carIx][0] <= itv[x][0] && itv[x][0] <= itv[carIx][1];
    }

    public static int count(int[][] itv, int i, int j) {
        int cnt = 0;
        for (int k = 0; k < itv.length; k++) {
            if (hit(itv, i, k) || hit(itv, j, k)) {
                cnt++;
            }
        }
        return cnt;
    }

    public static int solve(int[][] itv) {
        final int n = itv.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                max = Math.max(max, count(itv, i, j));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] itv = new int[n][2];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int l = sc.nextInt();
            itv[i][0] = x;
            itv[i][1] = x + l;
        }

        System.out.println(solve(itv));
    }
}

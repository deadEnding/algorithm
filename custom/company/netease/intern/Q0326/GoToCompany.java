package custom.company.netease.intern.Q0326;

import java.util.Scanner;

/**
 * Created by deadend on 2017/3/26.
 */
public class GoToCompany {

    public static int resolve(int n, int[] x, int[] y, int gx, int gy, int walk, int taxi) {
        int min = (Math.abs(gx) + Math.abs(gy)) * walk;
        int[] taxiTime = new int[n];
        for (int i = 0; i < n; i++) {
            taxiTime[i] += (Math.abs(x[i]) + Math.abs(y[i])) * walk;
            taxiTime[i] += (Math.abs(x[i] - gx) + Math.abs(y[i] - gy)) * taxi;
            min = Math.min(min, taxiTime[i]);
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
        }

        for (int j = 0; j < n; j++) {
            y[j] = sc.nextInt();
        }

        int gx = sc.nextInt();
        int gy = sc.nextInt();
        int walk = sc.nextInt();
        int taxi = sc.nextInt();
        System.out.println(resolve(n, x, y, gx, gy, walk, taxi));
    }
}

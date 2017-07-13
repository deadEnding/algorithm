package custom.company.microsoft.internship.Q201704.A;

import java.util.Scanner;

public class Main {

//    private static int X = 1000000000;
//
//    public static int[] row = new int[X];
//    public static int[] col = new int[2 * X + 10];
//    public static int[] dig = new int[2 * X + 10];
//    public static int[] rdig = new int[X];
//
//    public static int solve(int[] x, int[] y, final int n) {
//        int count = 0;
//        for (int i = 0; i < n; i++) {
//            count += (row[x[i]]++) + (col[y[i]]++);
//            int rd = x[i] + y[i];
//            int d = x[i] - y[i] + X;
//            count += (dig[d]++) + (rdig[rd]++);
//        }
//        return count;
//    }

    public static int solve(int[] x, int[] y, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (x[i] == x[j] || y[i] == y[j] || x[i] - y[i] == x[j] - y[j] || x[i] + y[i] == x[j] + y[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        System.out.println(solve(x, y, n));
    }
}

package custom.company.microsoft.internship.Q201703.A;


import java.util.Scanner;

import static java.lang.Math.pow;

public class Main {
    private static void backtracking(int count, int req, int cur, double total, int n) {
        if (count == n) {
            exp += req*total;
        } else {
            if (count < 6)
                backtracking(count + 1, req + 1, p / (int)pow(2, count + 1), total*(cur*0.01), n);
            else
                backtracking(count + 1, req + 1, 0, total*(cur*0.01), n);

            if(cur != 100)
                backtracking(count, req + 1, cur + q >= 100 ? 100: cur + q, total*(1 - cur * 0.01), n);
        }
    }

    private static int n;
    private static int q;
    private static int p;
    private static double exp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        p = sc.nextInt(); q = sc.nextInt(); n = sc.nextInt();
        backtracking(0, 0, p, 1, n);
        System.out.println(String.format("%.2f", exp));
    }
}

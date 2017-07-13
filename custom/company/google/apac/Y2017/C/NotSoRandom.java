package custom.company.google.apac.Y2017.C;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author: deadend
 * @date: 11:58 AM 1/7/17
 * @version: 1.0
 * @description:
 */


public class NotSoRandom {

    public static double expect(int n, int x, int k, int a, int b, int c) {
        double[][] dp = new double[n + 1][2];
        double ex = 0.0;
        int base = 1;
        while (x > 0 || k > 0) {
            int xb = x & 1;
            int kb = k & 1;
            dp[0][xb] = 1;
            dp[0][1 - xb] = 0;
            for (int i = 0; i < n; i++) {
                if (kb == 0) {
                    dp[i + 1][0] = dp[i][0] + dp[i][1] * a / 100;
                    dp[i + 1][1] = dp[i][1] * (b + c) / 100;
                } else {
                    dp[i + 1][0] = dp[i][0] * a / 100 + dp[i][1] * c / 100;
                    dp[i + 1][1] = dp[i][0] * (b + c) / 100 + dp[i][1] * (a + b) / 100;
                }
            }
            ex += dp[n][1] * base;
            base <<= 1;
            x >>= 1;
            k >>= 1;
        }
        return ex;
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("/tmp/D-large-practice.in");
        System.setIn(fis);

        PrintStream ps = new PrintStream(new FileOutputStream("/tmp/D-large-practice.out"));
        System.setOut(ps);

        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        DecimalFormat df = new DecimalFormat("0.0000000000");
        for (int i = 1; i <= cases; i++) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int k = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            System.out.println("Case #" + i + ": " + df.format(expect(n, x, k, a, b, c)));
        }
    }
}

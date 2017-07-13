package custom.company.google.kickstart.practice.B;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author: deadend
 * @date: 8:17 PM 3/3/17
 * @version: 1.0
 * @description: http://www.cnblogs.com/mj-liylho/p/6422283.html，取对数防止溢出x = lgN，最后再计算e的x次方即结果
 */


public class Probability {

    private static double prob(int m, int n) {
        double[] dp = new double[n + 1];

        for (int j = 1; j <= n; j++) {
            dp[j] = Math.log(1.0);
        }

        for (int i = 1; i <= m; i++) {
            for (int j = i + 2; j <= n; j++) {
                dp[j] = dp[j - 1] + Math.log(1 + Math.exp(dp[j] - dp[j - 1]));
            }
        }

        double result = 0;
        for (int i = 1; i <= m; i++) {
            result += Math.log(i) - Math.log(n + i);
        }
        result += dp[n];
        result = Math.exp(result);
        return result;
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("/tmp/B-large-practice.in");
        System.setIn(fis);

        PrintStream ps=new PrintStream(new FileOutputStream("/tmp/B-large-practice.out"));
        System.setOut(ps);

        Scanner sc = new Scanner(System.in);
        int cases = Integer.valueOf(sc.nextLine());
        for (int _c = 1; _c <= cases; _c++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.println("Case #" + _c + ": " + Probability.prob(m, n));
        }
    }
}

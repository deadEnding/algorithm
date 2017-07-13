package custom.company.google.kickstart.roundA.B;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author: deadend
 * @date: 2:30 PM 3/5/17
 * @version: 1.0
 * @description:
 */


public class PatternsOverlap {

    private static boolean check(String s1, String s2) {
        s1 = s1.replace("*", "....");
        s2 = s2.replace("*", "....");

        final int n1 = s1.length();
        final int n2 = s2.length();
        boolean[][] dp = new boolean[n1 + 1][n2 + 1];

        dp[0][0] = true;
        for (int i = 1; i <= n1; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == '.';
        }

        for (int j = 1; j <= n2; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == '.';
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                dp[i][j] = false;
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] |= dp[i - 1][j - 1];
                }
                if (s1.charAt(i - 1) == '.') {
                    dp[i][j] |= dp[i - 1][j - 1] | dp[i - 1][j];
                }

                if (s2.charAt(j - 1) == '.') {
                    dp[i][j] |= dp[i - 1][j - 1] | dp[i][j - 1];
                }
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("/home/deadend/Downloads/B-large.in");
        System.setIn(fis);

        PrintStream ps=new PrintStream(new FileOutputStream("/home/deadend/Downloads/B-large.out"));
        System.setOut(ps);

        Scanner sc = new Scanner(System.in);
        int cases = Integer.valueOf(sc.nextLine());
        for (int _c = 1; _c <= cases; _c++) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            boolean ret = check(s1, s2);
            System.out.println("Case #" + _c + ": " + (ret ? "TRUE" : "FALSE"));
        }
    }
}

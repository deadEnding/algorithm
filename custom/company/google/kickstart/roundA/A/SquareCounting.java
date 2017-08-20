package custom.company.google.kickstart.roundA.A;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author: deadend
 * @date: 2:07 PM 3/5/17
 * @version: 1.0
 * @description:
 */


public class SquareCounting {

    private static int count(int m, int n) {
        if (m > n) {
            int t = m;
            m = n;
            n = t;
        }

        long sum = 0;
        for (int i = 1; i < m; i++) {
            sum = (sum + ((long)m - i) * (n - i)) % 1000000007;
        }

        for (int i = 2; i < m; i++) {
            sum = (sum + ((long)m - i) * (n - i) * (i - 1)) % 1000000007;
        }

        return (int)sum;
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("/home/deadend/Downloads/B-large.in");
        System.setIn(fis);

        PrintStream ps=new PrintStream(new FileOutputStream("/home/deadend/Downloads/B-large.out"));
        System.setOut(ps);

        Scanner sc = new Scanner(System.in);
        int cases = Integer.valueOf(sc.nextLine());
        for (int _c = 1; _c <= cases; _c++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int cnt = count(m, n);
            System.out.println("Case #" + _c + ": " + cnt);
        }
    }
}

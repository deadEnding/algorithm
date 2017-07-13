package custom.company.google.kickstart.practice.C;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author: deadend
 * @date: P10:03 PM 3/3/17
 * @version: 1.0
 * @description:
 */


public class SherlockAndParentheses {

    private static long count(int n) {
        long cnt = 0;
        for (int i = 1; i <= n; i++) {
            cnt += i;
        }
        return cnt;
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("/tmp/D-large-practice.in");
        System.setIn(fis);

        PrintStream ps=new PrintStream(new FileOutputStream("/tmp/D-large-practice.out"));
        System.setOut(ps);

        Scanner sc = new Scanner(System.in);
        int cases = Integer.valueOf(sc.nextLine());
        for (int _c = 1; _c <= cases; _c++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            System.out.println("Case #" + _c + ": " + SherlockAndParentheses.count(Math.min(m, n)));
        }
    }
}

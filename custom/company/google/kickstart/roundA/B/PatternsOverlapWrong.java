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


public class PatternsOverlapWrong {

    private static boolean backtrace(String s1, int i1, String s2, int i2, int[][] cache) {
        if (i1 >= s1.length() && i2 >= s2.length()) {
            return true;
        }

        if (i1 >= s1.length() || i2 >= s2.length()) {
            return false;
        }

        if (cache[i1][i2] != 0) {
            return cache[i1][i2] == 1;
        }

        char c1 = s1.charAt(i1);
        char c2 = s2.charAt(i2);
        if (c1 == '*' && c2 == '*') {
            for (int ix = 0; ix <= 5; ix++) {
                if (backtrace(s1, i1 + 1, s2, i2 + ix, cache)) {
                    cache[i1][i2] = 1;
                    return true;
                }
            }

            for (int ix = 0; ix <= 5; ix++) {
                if (backtrace(s1, i1 + ix, s2, i2 + 1, cache)) {
                    cache[i1][i2] = 1;
                    return true;
                }
            }
        } else if (c1 == '*') {
            for (int ix = 0; ix <= 4; ix++) {
                if (backtrace(s1, i1 + 1, s2, i2 + ix, cache)) {
                    cache[i1][i2] = 1;
                    return true;
                }
            }
        } else if (c2 == '*') {
            for (int ix = 0; ix <= 4; ix++) {
                if (backtrace(s1, i1 + ix, s2, i2 + 1, cache)) {
                    cache[i1][i2] = 1;
                    return true;
                }
            }
        } else if (c1 == c2) {
            if (backtrace(s1, i1 + 1, s2, i2 + 1, cache)) {
                cache[i1][i2] = 1;
                return true;
            }
        }
        cache[i1][i2] = -1;
        return false;
    }

    private static boolean check(String s1, String s2) {
        return backtrace(s1, 0, s2, 0, new int[s1.length()][s2.length()]);
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("/home/deadend/Downloads/B-small-attempt1.in");
        System.setIn(fis);

        PrintStream ps=new PrintStream(new FileOutputStream("/home/deadend/Downloads/B-small-attempt1.out"));
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

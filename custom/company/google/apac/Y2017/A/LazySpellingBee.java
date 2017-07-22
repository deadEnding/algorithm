package custom.company.google.apac.Y2017.A;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author: deadend
 * @date: P10:20 AM 1/7/17
 * @version: 1.0
 * @description:
 */


public class LazySpellingBee {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("/tmp/L476_NumberComplement-large-practice1.in");
        System.setIn(fis);

        PrintStream ps=new PrintStream(new FileOutputStream("/tmp/L476_NumberComplement-large-practice1.out"));
        System.setOut(ps);

        final int MOD = 1000000007;
        Scanner sc = new Scanner(System.in);
        int cases = Integer.valueOf(sc.nextLine());
        for (int i = 1; i <= cases; i++) {
            long count = 1;
            String line = sc.nextLine();
            for (int j = 0; j < line.length(); j++) {
                HashSet<Character> set = new HashSet<>();
                for (int k = j - 1; k <= j + 1; k++) {
                    if (k < 0 || k >= line.length()) {
                        continue;
                    }
                    set.add(line.charAt(k));
                }
                count *= set.size();
                count %= MOD;
            }
            System.out.println("Case #" + i + ": " + count);
        }
    }
}

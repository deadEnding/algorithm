package custom.company.google.kickstart.roundC.A;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class AmbiguousCipher {
    private static int c2i(char c) {
        return c - 'A';
    }

    private static char i2c(int i) {
        return (char) (i + 'A');
    }

    private static String solve(String s) {
        if (s.length() % 2 == 1) {
            return "AMBIGUOUS";
        }

        final int n = s.length();
        char[] ori = new char[n];
        char[] now = s.toCharArray();
        ori[1] = now[0];
        for (int i = 3; i < n; i += 2) {
            ori[i] = i2c((c2i(now[i - 1]) + 26 - c2i(ori[i - 2])) % 26);
        }

        ori[n - 2] = now[n - 1];
        for (int i = n - 4; i >= 0; i -= 2) {
            ori[i] = i2c((c2i(now[i + 1]) + 26 - c2i(ori[i + 2])) % 26);
        }

        return new String(ori);
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("/Users/deadend/Downloads/A-large-practice1.in");
        System.setIn(fis);

        PrintStream ps=new PrintStream(new FileOutputStream("/Users/deadend/Downloads/A-large.out"));
        System.setOut(ps);

        Scanner sc = new Scanner(System.in);
        int cases = Integer.valueOf(sc.nextLine());
        for (int i = 1; i <= cases; i++) {
            String s = sc.nextLine();
            System.out.println(String.format("Case #%d: %s", i, solve(s)));
        }
    }
}

package custom.company.google.kickstart.practice1.A;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author: deadend
 * @date: 7:42 PM 3/3/17
 * @version: 1.0
 * @description:
 */


public class FindLeader {

    private static int dist(String s) {
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c))
                set.add(c);
        }
        return set.size();
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("/tmp/A-large-practice1.in");
        System.setIn(fis);

        PrintStream ps=new PrintStream(new FileOutputStream("/tmp/A-large-practice1.out"));
        System.setOut(ps);

        Scanner sc = new Scanner(System.in);
        int cases = Integer.valueOf(sc.nextLine());
        for (int i = 1; i <= cases; i++) {
            String s = null;
            int max = 0;
            int num = Integer.valueOf(sc.nextLine());
            for (int j = 0; j < num; j++) {
                String t = sc.nextLine();
                int d = dist(t);
                if (d > max) {
                    s = t;
                    max = d;
                } else if (d == max) {
                    s = t.compareTo(s) < 0 ? t : s;
                }
            }

            System.out.println("Case #" + i + ": " + s);
        }
    }
}

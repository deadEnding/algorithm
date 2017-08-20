package custom.company.google.kickstart.practice2.A;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class DiwaliLightings {

    public static void main(String[] args) throws FileNotFoundException {
//        FileInputStream fis = new FileInputStream("/Users/deadend/Downloads/B-small-practice.in");
//        PrintStream ps=new PrintStream(new FileOutputStream("/Users/deadend/Downloads/B-small.out"));
        FileInputStream fis = new FileInputStream("/Users/deadend/Downloads/B-large-practice.in");
        PrintStream ps=new PrintStream(new FileOutputStream("/Users/deadend/Downloads/B-large.out"));
        System.setIn(fis);
        System.setOut(ps);

        Scanner sc = new Scanner(System.in);
        int cases = Integer.valueOf(sc.nextLine());

        for (int c = 1; c <= cases; c++) {
            String p = sc.nextLine();
            String[] lr = sc.nextLine().split(" ");
            long l = Long.valueOf(lr[0]);
            long r = Long.valueOf(lr[1]);

            int cnt = 0;
            for (char ch : p.toCharArray()) {
                cnt += ch == 'B' ? 1 : 0;
            }

            int len = p.length();
            long total = (r + 1 - l) / len * cnt;

            for (int i = 0; i < (r + 1 - l) % len; i++) {
                total += p.charAt((int)((l + i - 1 + len) % len)) == 'B' ? 1 : 0;
            }

            System.out.println(String.format("Case #%d: %d", c, total));
        }
    }
}

package custom.company.google.kickstart.roundD.B;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class B {

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("/Users/deadend/Downloads/B-small.in");
        PrintStream ps=new PrintStream(new FileOutputStream("/Users/deadend/Downloads/B-small.out"));
//        FileInputStream fis = new FileInputStream("/Users/deadend/Downloads/B-large.in");
//        PrintStream ps=new PrintStream(new FileOutputStream("/Users/deadend/Downloads/B-large.out"));
//        System.setIn(fis);
//        System.setOut(ps);

        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();

        for (int _c = 1; _c <= cases; _c++) {
//            System.out.println(String.format("Case #%d: %d", _c, --));
        }
    }
}

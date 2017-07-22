package custom.company.google.apac.Y2017.B;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: deadend
 * @date: 11:21 AM 1/7/17
 * @version: 1.0
 * @description:
 */


public class RobotRockBand {

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("/tmp/B-large-practice1.in");
        System.setIn(fis);

        PrintStream ps = new PrintStream(new FileOutputStream("/tmp/B-large-practice1.out"));
        System.setOut(ps);

        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int c = 1; c <= cases; c++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[][] ids = new int[4][n];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < n; j++) {
                    ids[i][j] = sc.nextInt();
                }
            }

            HashMap<Integer, Integer> counter = new HashMap<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int t = ids[0][i] ^ ids[1][j] ^ k;
                    counter.put(t, counter.containsKey(t) ? counter.get(t) + 1 : 1);
                }
            }

            long count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int t = ids[2][i] ^ ids[3][j];
                    count += counter.containsKey(t) ? counter.get(t) : 0;
                }
            }
            System.out.println("Case #" + c + ": " + count);
        }
    }
}

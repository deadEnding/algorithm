package custom.company.sohu.Q2;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static int resolve(int n) {
        long t = 1L;
        for (int i = 1; true; i++) {
            if (t % n == 0) {
                return i;
            }
            t = t * 10 + 1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            System.out.println(resolve(sc.nextInt()));
        }
    }
}

package custom.company.indeed.first.A;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int rs = 0, re = n - 1;
        int cs = 0, ce = n - 1;
        int count = 0;
        while (m > 0) {
            count = ce - cs + 1;
            if (m <= count) {
                System.out.println((rs + 1) + " " + (cs + m));
                return;
            }
            m -= count;
            rs++;

            count = re - rs + 1;
            if (m <= count) {
                System.out.println((rs + m) + " " + (ce + 1));
                return;
            }
            m -= count;
            ce--;

            count = ce - cs + 1;
            if (m <= count) {
                System.out.println((re + 1) + " " + (ce - m + 2));
                return;
            }
            m -= count;
            re--;

            count = re - rs + 1;
            if (m <= count) {
                System.out.println((re - m + 2) + " " + (cs + 1));
                return;
            }
            m -= count;
            cs++;
        }
    }
}

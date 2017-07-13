package custom.company.qihu.I0325.A;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by deadend on 2017/3/25.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += sc.nextInt() * sc.nextInt();
        }

        DecimalFormat df = new DecimalFormat("0.000");
        System.out.println(df.format((double) sum / 100));
    }
}

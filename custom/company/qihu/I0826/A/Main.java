package custom.company.qihu.I0826.A;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();

        int p = m / c;
        int q = n / d;
        int max = 0;
        for (int i = 0; i <= p; i++) {
            for (int j = 0; j <= q; j++) {
                int v1 = i * y;
                int v2 = j * z;
                int v0 = Math.min((m - i * c) / b, (n - j * d) / a) * x;
                max = Math.max(v0 + v1 + v2, max);
            }
        }
        System.out.println(max);
    }
}

package custom.company.yixin.B;

import java.util.Scanner;

public class Main {

    public static final int MOD = 100003;

    public static long fastExp(long x, long p, long mod) {
        long result = 1;

        long base = x % mod;
        while (p > 0) {
            if (p % 2 == 1) {
                result = (result * base) % mod;
            }

            base = base * base % mod;
            p >>= 1;
        }

        return result;
    }

    public static long solve(long n, long w) {
        long x = fastExp(n, w, MOD);
        long y = fastExp(n - 1, w - 1, MOD) * n % MOD;
        return (x - y + MOD) % MOD;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long w = sc.nextLong();
        System.out.println(solve(n, w));
    }
}

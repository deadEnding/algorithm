package custom.company.google.kickstart.roundB.A;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class MathEncoder {

    private static final int MOD = 1000000007;

    private static int n;
    private static int[] nums;

    private static long power(int x, int p, int mod) {
        long result = 1;

        long base = x % mod;
        while (p > 0) {
            if (p % 2 == 1) {
                result = (result * base) % mod;
            }

            base = (base * base) % mod;
            p >>= 1;
        }

        return result;
    }

    private static long solve() {
        Arrays.sort(nums);
        long ans = 0L;
        for (int i = 0; i < n; i++) {
            long delta = (power(2, i, MOD) - power(2, n - 1 - i, MOD)) * nums[i] % MOD;
            ans = (ans + delta + MOD) % MOD;
        }

        return (ans + MOD) % MOD;
    }

    public static void main(String[] args) throws FileNotFoundException {
//        FileInputStream fis = new FileInputStream("/Users/deadend/Downloads/B-small-practice1.in");
//        PrintStream ps=new PrintStream(new FileOutputStream("/Users/deadend/Downloads/B-small.out"));
        FileInputStream fis = new FileInputStream("/Users/deadend/Downloads/B-large-practice1.in");
        PrintStream ps=new PrintStream(new FileOutputStream("/Users/deadend/Downloads/B-large.out"));
        System.setIn(fis);
        System.setOut(ps);

        Scanner sc = new Scanner(System.in);
        int cases = Integer.valueOf(sc.nextLine());
        for (int c = 1; c <= cases; c++) {
            n = Integer.valueOf(sc.nextLine());
            nums = new int[n];
            String[] ss = sc.nextLine().split(" ");
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.valueOf(ss[i]);
            }

            System.out.println(String.format("Case #%d: %d", c, solve()));
        }
    }
}

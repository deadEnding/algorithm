package hihocoder.practice.P11.D;

import java.util.Scanner;

public class Main {

    static class BIT {
        int[] sums;

        public BIT(int n) {
            sums = new int[n];
        }

        public int lowbit(int x) {
            return x & -x;
        }

        public void add(int ix, int diff) {
            while (ix < sums.length) {
                sums[ix] += diff;
                ix += lowbit(ix);
            }
        }

        public int sum(int ix) {
            int s = 0;
            while (ix > 0) {
                s += sums[ix];
                ix -= lowbit(ix);
            }
            return s;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            BIT bit = new BIT(n + 1);
            int[] sums = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                sums[i] = sums[i - 1] + sc.nextInt();
                bit.add(i, sums[i]);
            }

            for (int i = 0; i < m; i++) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                System.out.println(bit.sum(r) - bit.sum(l - 1) - (r - l + 1) * sums[l - 1]);
            }
        }
    }
}

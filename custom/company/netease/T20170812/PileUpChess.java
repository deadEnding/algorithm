package custom.company.netease.T20170812;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://mp.weixin.qq.com/s?__biz=MzAxMTc3NjE2NQ==&mid=2722852928&idx=1&sn=99aef242f042fc21904e1cb64b1e2b71&chksm=bc04298a8b73a09c7d53460869c9611c32bca2fe9a13feca2bea37f9c257d3a0b45531e0e963&mpshare=1&scene=1&srcid=0812FIWQslnFw2xzpCD4jXW6&key=6e89f52ea7a60cbe1e30fd562a8f6e8d361c5a01bb7ac3929970cc11061bb370b86334d227ce3cea6daf4a3c70f30e66ebc3612df39231637373f09a8bdf40b04b7edd4b9ab06a8d6327c5da7b498256&ascene=0&uin=MjQwNTMyNDE0MA%3D%3D&devicetype=iMac+MacBookPro13%2C1+OSX+OSX+10.12.3+build(16D32)&version=12020810&nettype=WIFI&fontScale=100&pass_ticket=mb%2FTqGEpMmAqGSxncvAozVECjidTBdFBoA5d8bzdD5TsuNNLfYKipRGoVhKpzZWf
 */

public class PileUpChess {
    private static int n;
    private static long[] x;
    private static long[] y;

    public static void solve() {
        for (int i = 1; i <= n; i++) {
            long min = Long.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    long[] d = new long[n];
                    for (int l = 0; l < n; l++) {
                        d[l] = Math.abs(x[j] - x[l]) + Math.abs(y[k] - y[l]);
                    }

                    Arrays.sort(d);
                    long sum = 0;
                    for (int l = 0; l < i; l++) {
                        sum += d[l];
                    }

                    min = Math.min(min, sum);
                }
            }

            System.out.print(i == n ? min : (min + " "));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        x = new long[n];
        y = new long[n];

        for (int i = 0; i < n; i++) {
            x[i] = sc.nextLong();
        }

        for (int i = 0; i < n; i++) {
            y[i] = sc.nextLong();
        }

        solve();
    }
}

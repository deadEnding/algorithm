package custom.company.google.apac.Y2017.D;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: deadend
 * @date: 2:31 PM 1/7/17
 * @version: 1.0
 * @description: Undone
 */


public class SumsOfSums {

    public static long sum(long[] count, int l, int r) {
        long sum = 0;
        for (int i = l; i <= r; i++) {
            sum += count[i] * i;
        }
        return sum;
    }

    public static long[] getResult(int[] nums, int[][] query) {
        final int n = nums.length;
        final int MAX = 20000001;
        int[] presum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            presum[i + 1] = nums[i] + presum[i];
        }

        long[] sum = new long[MAX];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                int s = presum[j] - presum[i - 1];
                sum[s]++;
                max = Math.max(max, s);
            }
        }

        long[] count = new long[MAX + 1];   // 小于等于i的数的个数
        for (int i = 1; i < MAX; i++) {
            count[i] = sum[i] + count[i - 1];
        }


        long[] result = new long[query.length];
        for (int i = 0; i < query.length; i++) {
            int cl = Arrays.binarySearch(count, 0, max + 1, query[i][0]);
            int cr = Arrays.binarySearch(count,  0, max + 1, query[i][1]);
            int ix = cl, jx = cr;
            if (cl < 0) {
                ix = -(cl + 1);
                result[i] -= (query[i][0] - count[ix - 1] - 1) * ix;
            } else {
                ix = cl + 1;
                result[i] += cl;
            }
            if (cr < 0) {
                jx = -(cr + 1);
                result[i] -= (count[jx] - query[i][1]) * jx;
            }
            result[i] += sum(sum, ix, jx);
        }
        return result;
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("/tmp/D.in");
        System.setIn(fis);

        PrintStream ps = new PrintStream(new FileOutputStream("/tmp/D.out"));
        System.setOut(ps);

        Scanner sc = new Scanner(System.in);
        long cases = sc.nextInt();
        for (long i = 1; i <= cases; i++) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextInt();
            }
            int[][] query = new int[q][2];
            for (int j = 0; j < q; j++) {
                query[j][0] = sc.nextInt();
                query[j][1] = sc.nextInt();
            }
            System.out.println("Case #" + i + ":");
            long[] result = getResult(nums, query);
            for (long r : result) {
                System.out.println(r);
            }
        }
    }
}

package custom.company.microsoft.internship.Q201704.C;

import java.util.Scanner;

public class Main {

    public static long resolve(long[] a, long[] b, int n, long avg) {
        long count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (a[i] > avg && b[i] > avg) {
                a[i + 1] += a[i] - avg;
                count += a[i] - avg;
                b[i + 1] += b[i] - avg;
                count += b[i] - avg;
            } else if (a[i] > avg && b[i] == avg) {
                a[i + 1] += a[i] - avg;
                count += a[i] - avg;
            } else if (a[i] > avg && b[i] < avg) {
                long delta = Math.min(a[i] - avg, avg - b[i]);
                count += delta;
                b[i] += delta;
                a[i] -= delta;
                i--;
            } else if (a[i] == avg && b[i] > avg) {
                b[i + 1] += b[i] - avg;
                count += b[i] - avg;
            } else if (a[i] == avg && b[i] == avg) {
                continue;
            } else if (a[i] == avg && b[i] < avg) {
                b[i + 1] += avg - b[i];
                count += avg - b[i];
            } else if (a[i] < avg && b[i] == avg) {
                a[i + 1] -= avg - a[i];
                count += avg - a[i];
            } else if (a[i] < avg && b[i] < avg) {
                a[i + 1] -= avg - a[i];
                count += avg - a[i];
                b[i + 1] -= avg - b[i];
                count += avg - b[i];
            } else if (a[i] < avg && b[i] > avg) {
                long delta = Math.min(b[i] - avg, avg - a[i]);
                count += delta;
                a[i] += delta;
                b[i] -= delta;
                i--;
            }
        }
        return count + Math.abs(a[n - 1] - b[n - 1]) / 2;
    }

    public static void reverse(long[] a, int n) {
        for (int i = 0, j = n - 1; i < j ; i++, j--) {
            long t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        long[] b = new long[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            sum += b[i] = sc.nextInt();
        }

        long x1 = resolve(a, b, n, sum / 2 / n);
        reverse(a, n);
        reverse(b, n);
        long x2 = resolve(a, b, n, sum / 2 / n);
        System.out.println(Math.min(x1, x2));
    }
}

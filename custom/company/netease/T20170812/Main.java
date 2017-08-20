package custom.company.netease.T20170812;

import java.util.Scanner;

/**
 * Created by yuhui.zzc on 12/08/2017.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        int[] b = new int[n];
        if (n % 2 == 0) {
            int k = 0;
            for (int i = n - 1; i >= 0; i -= 2) {
                b[k++] = a[i];
            }

            for (int i = 0; i < n; i += 2) {
                b[k++] = a[i];
            }
        } else {
            int k = 0;
            for (int i = n - 1; i >= 0; i -= 2) {
                b[k++] = a[i];
            }

            for (int i = 1; i < n; i += 2) {
                b[k++] = a[i];
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(i == n - 1 ? b[i] : (b[i] + " "));
        }
    }
}

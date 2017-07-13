package custom.company.toutiao.D;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] w = new int[n + 1][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                w[i][j] = sc.nextInt();
            }
        }

        int[][] cnt = new int[n + 1][n];
        int[][] tw = new int[n + 1][n];

        for (int i = 0; i < n; i++) {
            cnt[n - 1][i] = 1;
            tw[n - 1][i] = w[n - 1][i];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                cnt[i][j] = cnt[i + 1][j] + cnt[i + 1][j + 1] + 1 - cnt[i + 2][j + 1];
                tw[i][j] = tw[i + 1][j] + tw[i + 1][j + 1] + w[i][j] - w[i + 2][j + 1];
            }
        }


        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (cnt[i][j] == k) {
                    max = Math.max(max, tw[i][j]);
                }
            }
        }

        System.out.println(max);
    }
}

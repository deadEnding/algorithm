package custom.company.qihu.I0826.C;

import java.util.Scanner;

public class Main {
    private static int n, n1, n2;
    private static int[] nums, nums1, nums2;
    private static long sum;
    private static int c;


    private static long solve() {
        long[][][] dp = new long[2][n1 + 1][c + 1];
        long max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, n1); j++) {
                for (int k = 1; k <= c; k++) {
                    dp[i % 2][j][k] = dp[(i - 1) % 2][j][k];
                    if (k >= nums[i - 1]) {
                        dp[i % 2][j][k] = Math.max(dp[i % 2][j][k], dp[(i - 1) % 2][j - 1][k - nums[i - 1]] + nums[i - 1]);
                    }
                    max = Math.max(max, dp[i % 2][j][k]);
                }
            }
        }
        return Math.abs(sum - max * 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n1 = sc.nextInt();
        nums1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            sum += nums1[i] = sc.nextInt();
        }

        n2 = sc.nextInt();
        nums2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            sum += nums2[i] = sc.nextInt();
        }

        n = n1 + n2;
        c = (int)(sum / 2);
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            if (i < n1)
                nums[i] = nums1[i];
            else
                nums[i] = nums2[i - n1];
        }
        System.out.println(solve());
    }
}

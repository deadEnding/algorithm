package custom.company.netease.intern.Q0326;

import java.util.Scanner;

/**
 * Created by deadend on 2017/3/26.
 */
public class TwoCPU {

    public static int resolve(int[] nums) {
        final int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int c = sum / 2;
        int[][] dp = new int[n + 1][c + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= c; j++) {
                if (j < nums[i]) {
                    dp[i + 1][j] = dp[i][j];
                } else {
                    dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - nums[i]] + nums[i]);
                }
            }
        }
        return Math.max(dp[n][c], sum - dp[n][c]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt() / 1024;
        }

        System.out.println(resolve(nums) * 1024);
    }
}

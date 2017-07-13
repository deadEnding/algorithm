package custom.company.qihu.I0318;

import java.util.Scanner;

/**
 * @author: deadend
 * @date: 7:58 PM 3/18/17
 * @version: 1.0
 * @description:
 */


public class A {

    private static int[] resolve(int[] nums) {
        final int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        int[][] max = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            max[i][i] = nums[i];
            for (int j = i + 1; j < n; j++) {
                max[i][j] = sum[j + 1] - sum[i] - Math.min(max[i + 1][j], max[i][j - 1]);
            }
        }

        return new int[] {max[0][n - 1], sum[n] - max[0][n - 1]};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int c = 1; c <= cases; c++) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            int[] res = resolve(nums);
            System.out.println(String.format("Case #%s: %d %d", String.valueOf(c), res[0], res[1]));
        }
    }
}

package custom.company.netease.intern.Q0325;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by deadend on 2017/3/25.
 */
public class MainA {

    private static boolean canSep(int[] nums, int c) {
        boolean[] dp = new boolean[c + 1];
        dp[0] = true;
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = c; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[c];
    }

    private static int max = -1;

    private static void backtrack(int ix, int[] nums, int sum1, int sum2, int[] sums) {
        if (ix == nums.length) {
            if (sum1 == sum2) {
                max = Math.max(max, sum1);
            }
            return;
        }

        int rear = sums[nums.length] - sums[ix];
        if (rear + sum1 < sum2 || rear + sum2 < sum1 || rear + Math.min(sum1, sum2) < max) {
            return;
        }

        backtrack(ix + 1, nums, sum1 + nums[ix], sum2, sums);
        backtrack(ix + 1, nums, sum1, sum2 + nums[ix], sums);
        backtrack(ix + 1, nums, sum1, sum2, sums);
    }

    private static int resolve1(int[] nums) {
        int[] sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        backtrack(0, nums, 0, 0, sum);
        return max;
    }

    private static int resolve2(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }

        if (sum % 2 == 0 && canSep(nums, sum / 2)) {
            return sum / 2;
        }

        for (int n : nums) {
            if ((sum - n) % 2 == 0 && canSep(nums, (sum - n) / 2)) {
                return (sum - n) / 2;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(resolve2(nums));
    }
}

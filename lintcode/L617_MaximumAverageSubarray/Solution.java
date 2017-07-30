package lintcode.L617_MaximumAverageSubarray;


import java.util.Random;

// Timeout
public class Solution {
    public double maxAverage(int[] nums, int k) {
        final int n = nums.length;
        Double max = null;
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = 1; j <= n - i; j++) {
                sum += nums[i + j - 1];
                if (j >= k) {
                    max = max == null ? sum * 1.0 / j : Math.max(max, sum * 1.0 / j);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
//        int[] nums = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
//        System.out.println(new Solution().maxAverage(nums, 2));

        Random random = new Random();
        while (true) {
            int r = random.nextInt(20);
            if (r == 0)
                break;
            else
                System.out.println(r);
        }
    }
}

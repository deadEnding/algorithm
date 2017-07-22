package leetcode.L164_MaximumGap;

import java.util.Arrays;

public class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        final int n = nums.length;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int gap = (int)Math.ceil((double)(max - min) / (n - 1)) + 1;
        int[] bucketMin = new int[n];
        int[] bucketMax = new int[n];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        for (int num : nums) {
            int bid = (num - min) / gap;
            bucketMin[bid] = Math.min(bucketMin[bid], num);
            bucketMax[bid] = Math.max(bucketMax[bid], num);
        }

        int maxGap = 0;
        int last = min;
        for (int i = 0; i < n; i++) {
            if (bucketMin[i] == Integer.MAX_VALUE && bucketMax[i] == Integer.MIN_VALUE) {
                continue;
            }

            if (bucketMin[i] != Integer.MAX_VALUE) {
                maxGap = Math.max(maxGap, bucketMin[i] - last);
                last = bucketMin[i];
            }

            if (bucketMin[i] != Integer.MIN_VALUE) {
                maxGap = Math.max(maxGap, bucketMax[i] - bucketMin[i]);
                last = bucketMax[i];
            }
        }
        return maxGap;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1};
        System.out.println(new Solution().maximumGap(nums));
    }
}

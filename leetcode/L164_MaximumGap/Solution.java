package leetcode.L164_MaximumGap;

import java.util.Arrays;
import java.util.LinkedList;



public class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        LinkedList<Integer>[] buckets = new LinkedList[10];
        for (int i = 0; i < 10; i++) {
            buckets[i] = new LinkedList<>();
        }

        for (int i = 0, exp = 1; i < 10; i++, exp *= 10) {

            for (int num : nums) {
                buckets[num / exp % 10].offer(num);
            }

            for (int j = 0, k = 0; j < 10; j++) {
                while (!buckets[j].isEmpty()) {
                    nums[k++] = buckets[j].poll();
                }
            }
        }

        int maxGap = 0;
        for (int i = 1; i < nums.length; i++) {
            maxGap = Math.max(maxGap, nums[i] - nums[i - 1]);
        }

        return maxGap;
    }
}


// 基数排序
class RadisSortingSolution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        LinkedList<Integer>[] buckets = new LinkedList[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }

        for (int i = 0, exp = 1; i < 10; i++, exp *= 10) {

            for (int n : nums) {
                buckets[n / exp % 10].offer(n);
            }

            for (int j = 0, k = 0; j < buckets.length; j++) {
                while (!buckets[j].isEmpty()) {
                    nums[k++] = buckets[j].poll();
                }
            }
        }

        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i] - nums[i - 1]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 9};
        System.out.println(new Solution().maximumGap(nums));
    }
}

class BucketSolution {
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

            if (bucketMax[i] != Integer.MIN_VALUE) {
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

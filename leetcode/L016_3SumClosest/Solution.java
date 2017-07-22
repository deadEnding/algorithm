package leetcode.L016_3sumClosest;

import java.util.Arrays;

/**
 * @author: deadend
 * @date: 9:22 PM 3/2/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        final int n = nums.length;
        Arrays.sort(nums);

        Integer minDiff = null;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1, k = n - 1; j < k;) {
                int sum = nums[i] + nums[j] + nums[k];
                if (minDiff == null || Math.abs(target - sum) < Math.abs(minDiff)) {
                    minDiff = target - sum;
                }

                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return target - minDiff;
    }
}

class OldSolution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        long closet = Long.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                long sum = (long) nums[i] + nums[j] + nums[k];
                if (closet == Long.MAX_VALUE || Math.abs(sum - target) < Math.abs(closet - target)) {
                    closet = sum;
                }

                if (sum < target) {
                    j++;
                } else if (sum > target) {
                    k--;
                } else {
                    return target;
                }
            }
        }
        return (int) closet;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,5,10,11};
        System.out.println(new Solution().threeSumClosest(nums, 12));
    }
}

package leetcode.L259_3sumSmaller;

import java.util.Arrays;

/**
 * @author: deadend
 * @date: 9:34 PM 3/P10/17
 * @version: 1.0
 * @description:
 */


class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        final int n = nums.length;
        int count = 0;

        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1, k = n - 1; j < k; j++) {
                while (j < k && nums[i] + nums[j] + nums[k] >= target) {
                    k--;
                }
                count += k - j;
            }
        }

        return count;
    }
}

class OldSolution {
    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1, k = nums.length - 1; j < k; j++) {
                while (j < k && nums[i] + nums[j] + nums[k] >= target) {
                    k--;
                }
                count += k - j;
            }
        }
        return count;
    }
}

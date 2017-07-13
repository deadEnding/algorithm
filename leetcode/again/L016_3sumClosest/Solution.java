package leetcode.again.L016_3sumClosest;

import java.util.Arrays;

/**
 * @author: deadend
 * @date: 9:22 PM 3/2/17
 * @version: 1.0
 * @description:
 */


public class Solution {
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

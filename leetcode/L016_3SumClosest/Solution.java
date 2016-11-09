package leetcode.L016_3SumClosest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 10:36 PM 11/9/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum - target) < Math.abs(min - target))
                    min = sum;
                if (sum < target) {
                    do {
                        j++;
                    } while (j < k && nums[j] == nums[j - 1]);
                } else if (sum > target)  {
                    do {
                        k--;
                    } while (j < k && nums[k] == nums[k + 1]);
                } else {
                    do {
                        j++;
                        k--;
                    } while (j < k && nums[j] == nums[j - 1] && nums[k] == nums[k + 1]);
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,-4};
        System.out.println(new Solution().threeSumClosest(nums, 1));
    }
}

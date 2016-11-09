package leetcode.L015_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 10:00 PM 11/9/16
 * @version: 1.0
 * @description:
 */


public class Solution {

    public List<List<Integer>> threeSum(final int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    do {
                        j++;
                    } while (j < k && nums[j] == nums[j - 1]);
                } else if (sum > 0) {
                    do {
                        k--;
                    } while (j < k && nums[k] == nums[k + 1]);
                } else {
                    ArrayList<Integer> tmp = new ArrayList<>(3);
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[k]);
                    result.add(tmp);
                    do {
                        j++;
                        k--;
                    } while (j < k && nums[j] == nums[j - 1] && nums[k] == nums[k + 1]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = new Solution().threeSum(nums);
        for (List<Integer> list : result) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

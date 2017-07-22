package leetcode.again.L018_4sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 9:39 PM 3/2/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    private ArrayList<Integer> build(int... nums) {
        ArrayList<Integer> tmp = new ArrayList<>();
        for (int num : nums) {
            tmp.add(num);
        }
        return tmp;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int m = j + 1;
                int n = nums.length - 1;

                while (m < n) {
                    long sum = (long) nums[i] + nums[j] + nums[m] + nums[n];
                    if (sum < target) {
                        m++;
                    } else if (sum > target) {
                        n--;
                    } else {
                        result.add(build(nums[i], nums[j], nums[m], nums[n]));
                        do {
                            m++;
                            n--;
                        } while (m < n && nums[m] == nums[m - 1] && nums[n] == nums[n + 1]);
                    }
                }
            }
        }
        return result;
    }
}

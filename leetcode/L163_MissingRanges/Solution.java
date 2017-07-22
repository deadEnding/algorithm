package leetcode.L163_MissingRanges;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 1:04 PM 3/P10/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new LinkedList<>();
        long prev = lower - 1L;
        for (int i = 0; i <= nums.length; i++) {
            long after = i == nums.length ? upper + 1L : nums[i];
            if (prev + 2 == after) {
                result.add(String.valueOf(prev + 1));
            } else if (prev + 2 < after) {
                result.add(String.valueOf(prev + 1) + "->" + String.valueOf(after - 1));
            }
            prev = after;
        }
        return result;
    }
}

class BasicSolution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new LinkedList<>();
        if (nums.length == 0) {
            if (upper == lower) {
                result.add(String.valueOf(lower));
            } else {
                result.add(lower + "->" + upper);
            }
            return result;
        }

        for (int i = 0, val = lower; i < nums.length; i++) {
            if (val != nums[i]) {
                if (val + 1 == nums[i]) {
                    result.add(String.valueOf(val));
                } else {
                    result.add(val + "->" + (nums[i] - 1));
                }
                val = nums[i] + 1;
            } else {
                val++;
            }

            while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                i++;
            }

            if (i == nums.length - 1 && nums[i] < upper) {
                result.add(nums[i] + 1 == upper ? String.valueOf(upper) : (nums[i] + 1 + "->" + upper));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int l = 1, u = 1;
        System.out.println(new Solution().findMissingRanges(nums, l, u));
    }
}

package leetcode.L228_SummaryRanges;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 11:11 PM 11/22/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new LinkedList<>();
        if (nums.length == 0) {
            return result;
        }

        int start = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                result.add(start == nums[i - 1] ? "" + start : start + "->" + nums[i - 1]);
                start = nums[i];
            }
        }
        result.add(start == nums[nums.length - 1] ? "" + start : start + "->" + nums[nums.length - 1]);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(new Solution().summaryRanges(nums));
    }
}

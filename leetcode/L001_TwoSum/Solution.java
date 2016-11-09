package leetcode.L001_TwoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: deadend
 * @date: 8:20 PM 11/9/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(target - nums[i], i);
            } else {
                return new int[]{map.get(nums[i]), i};
            }
        }
        return null;   // cannot reach
    }
}

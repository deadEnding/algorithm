package leetcode.L377_CombinationSumIV;


import java.util.Arrays;
import java.util.HashMap;

/**
 * @author: deadend
 * @date: 8:19 PM 12/18/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    private int helper(int[] nums, int target, HashMap<Integer, Integer> mem) {
        if (target <= 0) {
            return target == 0 ? 1 : 0;
        }

        if (!mem.containsKey(target)) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                count += helper(nums, target - nums[i], mem);
            }
            mem.put(target, count);
        }
        return mem.get(target);
    }

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        return helper(nums, target, new HashMap<Integer, Integer>());
    }

    public static void main(String[] args) {
        int[] nums = {3,33,333};
        System.out.println(new Solution().combinationSum4(nums, 10000));
    }
}
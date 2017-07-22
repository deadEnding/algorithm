package leetcode.L532_KdiffPairsInAnArray;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: 7:17 PM 01/04/2017
 */


public class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int count = 0;
        for (int key : map.keySet()) {
            if (k == 0) {
                count += map.getOrDefault(key, 0) >= 2 ? 1 : 0;
            } else {
                count += map.getOrDefault(key + k, 0) > 0 ? 1 : 0;
            }
        }
        return count;
    }
}

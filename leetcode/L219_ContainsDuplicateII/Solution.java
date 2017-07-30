package leetcode.L219_ContainsDuplicateII;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author: deadend
 * @date: P10:24 PM 11/22/16
 * @version: 1.0
 * @description:
 */

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        final int n = nums.length;

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0, start = 0; i < n; i++) {
            if (set.contains(nums[i])) {
                return true;
            }

            set.add(nums[i]);
            if (i - start == k) {
                set.remove(nums[start++]);
            }
        }
        return false;
    }
}

class MapSolution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}

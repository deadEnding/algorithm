package leetcode.L220_ContainsDuplicateIII;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author: deadend
 * @date: 10:37 PM 11/22/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || k < 1 || t < 0) {
            return false;
        }

        SortedSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            SortedSet<Long> subSet = set.subSet((long)nums[i] - t, (long)nums[i] + t + 1);
            if (!subSet.isEmpty()) {
                return true;
            }

            if (i >= k) {
                set.remove((long)nums[i - k]);
            }
            set.add((long)nums[i]);
        }
        return false;
    }
}

package leetcode.L217_ContainsDuplicate;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: deadend
 * @date: P10:14 PM 11/22/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) {
                return true;
            }
            set.add(n);
        }
        return false;
    }
}

package leetcode.L491_IncreasingSubsequences;

import java.util.*;

/**
 * @author: deadend
 * @date: 9:33 PM 2/4/17
 * @version: 1.0
 * @description:
 */

public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        helper(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> path, int[] nums, int ix) {
        if (path.size() > 1) {
            result.add(new ArrayList<>(path));
        }

        Set<Integer> uniq = new HashSet<>();
        for (int i = ix; i < nums.length; i++) {
            if ((ix > 0 && nums[i] < nums[ix - 1]) || uniq.contains(nums[i])) {
                continue;
            }
            uniq.add(nums[i]);
            path.add(nums[i]);
            helper(result, path, nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}

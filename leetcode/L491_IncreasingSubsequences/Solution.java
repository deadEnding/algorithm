package leetcode.L491_IncreasingSubsequences;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 7:39 PM 3/2/17
 * @version: 1.0
 * @description:
 */



public class Solution {
    private void dfs(int ix, int[] nums, LinkedList<Integer> path, List<List<Integer>> result) {
        if (path.size() >= 2)
            result.add(new LinkedList<>(path));

        HashSet<Integer> visited = new HashSet<>();
        for (int i = ix; i < nums.length; i++) {
            if ((ix - 1 >= 0 && nums[i] < nums[ix - 1]) || visited.contains(nums[i])) {
                continue;
            }
            visited.add(nums[i]);
            path.addLast(nums[i]);
            dfs(i + 1, nums, path, result);
            path.removeLast();
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        dfs(0, nums, new LinkedList<>(), result);
        return result;
    }
}

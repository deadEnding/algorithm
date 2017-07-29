package leetcode.L090_SubsetsII;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: P10:00 PM 3/2/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    private List<List<Integer>> result = new LinkedList<>();

    private void dfs(int ix, int[] nums, LinkedList<Integer> path) {
        result.add(new LinkedList<>(path));   // 与排列树的不同点：无判断条件

        HashSet<Integer> set = new HashSet<>();
        for (int i = ix; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }

            set.add(nums[i]);
            path.addLast(nums[i]);
            dfs(i + 1, nums, path);    // 与排列树的不同点：不是ix + 1，而是i + 1
            path.removeLast();
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        dfs(0, nums, new LinkedList<>());
        return result;
    }
}


class OldSolution {
    private void backtrace(int ix, int[] nums, LinkedList<Integer> path, List<List<Integer>> result) {
        result.add(new LinkedList<>(path));

        HashSet<Integer> set = new HashSet<>();
        for (int i = ix; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }

            set.add(nums[i]);
            path.addLast(nums[i]);
            backtrace(i + 1, nums, path, result);
            path.removeLast();
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        backtrace(0, nums, new LinkedList<>(), result);
        return result;
    }
}

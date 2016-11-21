package leetcode.L078_Subsets;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 9:23 AM 11/18/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    private List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, 0, new LinkedList<Integer>());
        return result;
    }

    private void helper(int[] nums, int ix, LinkedList<Integer> path) {
        if (ix >= nums.length) {
            result.add(new LinkedList<>(path));
            return;
        }

        helper(nums, ix + 1, path);

        path.addLast(nums[ix]);
        helper(nums, ix + 1, path);
        path.removeLast();
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> result = new Solution2().subsets(nums);
        for (List<Integer> list : result) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

class Solution2 {

    private List<List<Integer>> result = new LinkedList<>();

    private void dfs(int[] nums, int ix, LinkedList<Integer> path) {
        result.add(new LinkedList<Integer>(path));

        for (int i = ix; i < nums.length; i++) {
            path.addLast(nums[i]);
            dfs(nums, i + 1, path);
            path.removeLast();
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0, new LinkedList<Integer>());
        return result;
    }
}
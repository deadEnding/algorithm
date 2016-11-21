package leetcode.L090_SubsetsII;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 2:49 PM 11/21/16
 * @version: 1.0
 * @description:
 */


public class Solution {

    private List<List<Integer>> result = new LinkedList<>();

    private void dfs(int[] nums, int ix, LinkedList<Integer> path) {
        result.add(new LinkedList<>(path));

        for (int i = ix; i < nums.length; i++) {
            path.addLast(nums[i]);
            dfs(nums, i + 1, path);
            path.removeLast();

            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0, new LinkedList<Integer>());
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        List<List<Integer>> result = new Solution().subsetsWithDup(nums);
        for (List<Integer> list : result) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

package leetcode.L046_Permutations;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 11:18 AM 3/3/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    private List<Integer> array2list(int[] nums) {
        List<Integer> list = new LinkedList<>();
        for (int n : nums) {
            list.add(n);
        }
        return list;
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }

    private void permute(int ix, int[] nums, List<List<Integer>> result) {
        if (ix == nums.length) {
            result.add(array2list(nums));
            return;
        }

        for (int i = ix; i < nums.length; i++) {
            swap(nums, i, ix);
            permute(ix + 1, nums, result);
            swap(nums, i, ix);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        permute(0, nums, result);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(new Solution().permute(nums));
    }
}

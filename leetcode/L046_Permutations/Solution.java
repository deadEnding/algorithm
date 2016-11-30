package leetcode.L046_Permutations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 5:21 PM 11/30/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    private List<List<Integer>> result = new LinkedList<>();

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // nums[k..n-1]的全排列
    private void permute(int[] nums, int k) {
        if (k == nums.length) {
            List<Integer> tmp = new ArrayList<>(nums.length);
            for (int n : nums) {
                tmp.add(n);
            }
            result.add(tmp);
            return;
        }

        for (int i = k; i < nums.length; i++) {
            swap(nums, i, k);
            permute(nums, k + 1);
            swap(nums, i, k);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        permute(nums, 0);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        List<List<Integer>> result = new Solution().permute(nums);
        for (List<Integer> list : result) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

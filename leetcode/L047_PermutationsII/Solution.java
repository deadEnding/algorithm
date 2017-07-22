package leetcode.L047_PermutationsII;

import java.util.*;

/**
 * @author: deadend
 * @date: 8:57 AM 2/28/17
 * @version: 1.0
 * @description:
 */


public class Solution {

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    private void helper(HashMap<Integer, Integer> map, LinkedList<Integer> path, List<List<Integer>> result, int n) {
        if (path.size() == n) {
            result.add(new LinkedList<>(path));
            return;
        }

        for (int key : map.keySet()) {
            int val = map.get(key);
            if (val > 0) {
                map.put(key, val - 1);
                path.add(key);
                helper(map, path, result, n);
                path.remove(path.size() - 1);
                map.put(key, val);
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<List<Integer>> result = new LinkedList<>();
        helper(map, new LinkedList<>(), result, nums.length);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2};
        System.out.println(new Solution().permuteUnique(nums));
    }
}

class OtherSolution {

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    private void helper(int ix, int[] nums, List<List<Integer>> result) {
        if (ix == nums.length) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int n : nums) {
                tmp.add(n);
            }
            result.add(tmp);
            return;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = ix; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }

            set.add(nums[i]);
            swap(nums, ix, i);
            helper(ix + 1, nums, result);
            swap(nums, ix, i);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        helper(0, nums, result);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2};
        System.out.println(new OtherSolution().permuteUnique(nums));
    }
}
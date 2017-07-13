package leetcode.again.L442_FindAllDuplicatesInAnArray;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 9:38 PM 3/1/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public List<Integer> findDuplicates(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1) {
                if (nums[nums[i] - 1] == nums[i]) {
                    break;
                }
                swap(nums, i, nums[i] - 1);
            }
        }

        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                result.add(nums[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(new Solution().findDuplicates(nums));
    }
}

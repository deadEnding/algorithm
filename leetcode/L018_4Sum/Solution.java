package leetcode.L018_4Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 9:49 AM 11/P10/16
 * @version: 1.0
 * @description:
 */

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    int delta = nums[i] + nums[j] + nums[k] + nums[l] - target;
                    if (delta < 0) {
                        do {
                            k++;
                        } while (k < l && nums[k] == nums[k - 1]);
                    } else if (delta > 0) {
                        do {
                            l--;
                        } while (k < l && nums[l] == nums[l + 1]);
                    } else {
                        ArrayList<Integer> tmp = new ArrayList<>(4);
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[k]);
                        tmp.add(nums[l]);
                        result.add(tmp);
                        do {
                            k++;
                            l--;
                        } while (k < l && nums[k] == nums[k - 1] && nums[l] == nums[l + 1]);
                    }
                }

                while (j + 1 < nums.length - 1 && nums[j + 1] == nums[j]) {
                    j++;
                }
            }

            while (i + 1 < nums.length - 2 && nums[i + 1] == nums[i]) {
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0,0};
        List<List<Integer>> result = new Solution().fourSum(nums, 0);
        for (List<Integer> list : result) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

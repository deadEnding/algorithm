package leetcode.again.L015_3sum;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;



public class Solution {
    private List<Integer> build(int... nums) {
        List<Integer> result = new ArrayList<>(nums.length);
        for (int num : nums) {
            result.add(num);
        }

        return result;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        final int n = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < n - 2;) {
            for (int j = i + 1, k = n - 1; j < k;) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(build(nums[i], nums[j], nums[k]));
                    do {
                        j++;
                    } while (j < k && nums[j] == nums[j - 1]);
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }

            do {
                i++;
            } while (i < n - 2 && nums[i] == nums[i - 1]);

        }

        return result;
    }
}


class OldSolution {
    private List<Integer> build(int a, int b, int c) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(a);
        arr.add(b);
        arr.add(c);
        return arr;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        final int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1, k = n - 1; j < k;) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(build(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }

                while (j > i + 1 && j < k && nums[j] == nums[j - 1]) {
                    j++;
                }

                while (k < n - 1 && j < k && nums[k] == nums[k + 1]) {
                    k--;
                }
            }
        }
        return result;
    }
}

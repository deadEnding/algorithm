package leetcode.again.L015_3sum;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
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

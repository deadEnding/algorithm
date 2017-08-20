package custom.company.google.interview;

import java.util.Arrays;

/**
 * 求三个数之和小于等于 Target 的组合个数
 */
public class ThreeSumWithLessThanOrEqualToTarget {

    public int count(int[] nums, int target) {
        final int n = nums.length;

        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1, k = n - 1; j < k; j++) {
                while (j < k && nums[i] + nums[j] + nums[k] > target) {
                    k--;
                }

                count += k - j;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3};
        System.out.println(new ThreeSumWithLessThanOrEqualToTarget().count(nums, 6));
    }
}

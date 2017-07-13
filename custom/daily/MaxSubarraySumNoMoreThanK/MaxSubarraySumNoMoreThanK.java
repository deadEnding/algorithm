package custom.daily.MaxSubarraySumNoMoreThanK;

import java.util.TreeSet;

/**
 * @author: deadend
 * @date: 8:06 PM 2/17/17
 * @version: 1.0
 * @description: 求数组中连续子段和不超过K的最大值
 * https://www.quora.com/Given-an-array-of-integers-A-and-an-integer-k-find-a-subarray-that-contains-the-largest-sum-subject-to-a-constraint-that-the-sum-is-less-than-k
 */


public class MaxSubarraySumNoMoreThanK {

    public int maxSubarraySumNoMoreThanK(int[] nums, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);

        int max = Integer.MIN_VALUE;
        for (int i = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i];
            Integer ceil = set.ceiling(sum - k);  // 在之前的所有sum中求满足sum - oldsum <= k条件的oldsum的最小值
            if (ceil != null) {
                max = Math.max(max, sum - ceil);
            }
            set.add(sum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {2,4,3,4,6};
        System.out.println(new MaxSubarraySumNoMoreThanK().maxSubarraySumNoMoreThanK(nums, 7));
    }
}

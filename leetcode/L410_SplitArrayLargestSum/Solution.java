package leetcode.L410_SplitArrayLargestSum;

/**
 * @author: deadend
 * @date: 3:38 PM 12/22/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    private boolean greater(int[] nums, int m, long limit) {
        long subsum = 0;
        // count = 1, 最后一段在迭代过程中不会计入count，预先计入
        for (int i = 0, count = 1; i < nums.length; i++) {  
            subsum += nums[i];
            if (subsum > limit) {
                count++;
                if (count > m) {
                    return true;
                }
                subsum = nums[i];
            }
        }
        return false;
    }

    public int splitArray(int[] nums, int m) {
        int max = Integer.MIN_VALUE;
        long sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        if (m == 1) {
            return (int) sum;
        }

        long l = max, r = sum;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (greater(nums, m, mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return (int) l;
    }
}
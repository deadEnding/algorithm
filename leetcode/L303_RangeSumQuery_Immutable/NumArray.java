package leetcode.L303_RangeSumQuery_Immutable;

/**
 * @author: deadend
 * @date: 10:02 PM 12/12/16
 * @version: 1.0
 * @description:
 */


public class NumArray {

    private int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        if (nums.length == 0) {
            return;
        }

        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}

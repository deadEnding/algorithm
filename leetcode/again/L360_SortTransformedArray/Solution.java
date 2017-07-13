package leetcode.again.L360_SortTransformedArray;

/**
 * @author: deadend
 * @date: 12:45 PM 3/12/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        final int n = nums.length;
        int[] result = new int[n];

        if (a == 0) {
            for (int i = 0; i < n; i++) {
                result[i] = (b >= 0 ? nums[i] : nums[n - 1 - i]) * b + c;
            }
        } else {
            double k = -b / (2.0 * a);
            for (int i = 0, j = n - 1, ix = 0; i <= j; ix++) {
                double d1 = Math.abs(nums[i] - k);
                double d2 = Math.abs(nums[j] - k);
                int x = d1 > d2 ? nums[i++] : nums[j--];
                int index = a > 0 ? n - 1 - ix : ix;
                result[index] = a * x * x + b * x + c;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -2, 2, 4};
        int[] result = new Solution().sortTransformedArray(nums, 0, -3, 5);
        for (int r : result) {
            System.out.println(r);
        }
    }
}

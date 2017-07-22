package leetcode.L238_ProductOfArrayExceptSelf;


public class Solution {
    public int[] productExceptSelf(int[] nums) {
        final int n = nums.length;
        int[] result = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            result[i] = i == n - 1 ? 1 : result[i + 1] * nums[i + 1];
        }

        for (int i = 0, left = 1; i < n; i++) {
            result[i] *= left;
            left *= nums[i];
        }

        return result;
    }
}


class BasicSolution {
    public int[] productExceptSelf(int[] nums) {
        final int n = nums.length;

        int[] left = new int[n + 1];
        int[] right = new int[n + 1];
        left[0] = right[n] = 1;

        for (int i = 0; i < n; i++) {
            left[i + 1] = left[i] * nums[i];
        }

        for (int i = n - 1; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i];
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = left[i] * right[i + 1];
        }

        return result;
    }
}

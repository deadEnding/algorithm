package leetcode.again.L611_ValidTriangleNumber;


import java.util.Arrays;

public class Solution {
    public int triangleNumber(int[] nums) {
        final int n = nums.length;

        int count = 0;
        Arrays.sort(nums);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0, k = i - 1; j < k; k--) {
                while (j < k && nums[j] + nums[k] <= nums[i]) {
                    j++;
                }

                count += k - j;
            }
        }

        return count;
    }
}

package leetcode.L581_ShortestUnsortedContinuousSubarray;


public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        final int n = nums.length;
        int[] max = new int[n + 1];
        int[] min = new int[n + 1];

        max[0] = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max[i + 1] = Math.max(max[i], nums[i]);
        }

        min[n] = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            min[i] = Math.min(min[i + 1], nums[i]);
        }

        int left = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= min[i + 1]) {
                left = i;
            } else {
                break;
            }
        }

        int right = n;
        for (int i = n - 1; i > left; i--) {
            if (nums[i] >= max[i]) {
                right = i;
            } else {
                break;
            }
        }

        return right - left - 1;
    }
}

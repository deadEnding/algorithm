package leetcode.L042_TrappingRainWater;

/**
 * @author: deadend
 * @date: 9:07 AM 11/14/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int trap(int[] height) {
        final int n = height.length;

        int water = 0;
        for (int l = 0, r = n - 1, level = 0; l < r;) {
            int lower = height[height[l] < height[r] ? l++ : r--];
            level = Math.max(level, lower);
            water += level - lower;
        }

        return water;
    }

    public static void main(String[] args) {
        int[] height = {1,2,1};
        System.out.println(new Solution().trap(height));
    }
}

class Solution2 {

    public int trap(int[] height) {
        final int n = height.length;
        if (n <= 2) {
            return 0;
        }

        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = height[0];
        right[n-1] = height[n-1];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i-1], height[i]);
            right[n-1-i] = Math.max(right[n-i], height[n-1-i]);
        }

        int water = 0;
        for (int i = 0; i < n; i++) {
            water += Math.min(left[i], right[i]) - height[i];
        }
        return water;
    }

}

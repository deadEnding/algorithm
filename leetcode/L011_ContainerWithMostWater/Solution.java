package leetcode.again.L011_ContainerWithMostWater;


public class Solution {
    public int maxArea(int[] height) {
        final int n = height.length;

        int max = 0;
        for (int i = 0, j = n - 1; i < j;) {
            max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return max;
    }
}

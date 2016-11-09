package leetcode.L011_ContainerWithMostWater;

/**
 * @author: deadend
 * @date: 9:46 PM 11/9/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j;) {
            if (height[i] < height[j]) {
                max = Math.max(max, height[i] * (j - i));
                i++;
            } else {
                max = Math.max(max, height[j] * (j - i));
                j--;
            }
        }
        return max ;
    }

    public static void main(String[] args) {
        int[] height = {15};
        System.out.println(new Solution().maxArea(height));
    }
}

package leetcode.L042_TrappingRainWater;

/**
 * @author: deadend
 * @date: 9:34 AM 3/4/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int trap(int[] height) {
        final int n = height.length;

        int sum = 0;
        int lh = 0, rh = 0;
        for (int l = 0, r = n - 1; l <= r;) {
            if (height[l] <= height[r]) {
                lh = Math.max(lh, height[l]);
                sum += lh - height[l];
                l++;
            } else {
                rh = Math.max(rh, height[r]);
                sum += rh - height[r];
                r--;
            }
        }

        return sum;
    }
}

class OldSolution {
    public int trap(int[] height) {
        final int n = height.length;
        int sum = 0;
        int lmax = 0, rmax = 0;
        for (int i = 0, j = n - 1; i <= j;) {
            if (lmax < rmax) {
                sum += height[i] < lmax ? lmax - height[i] : 0;
                lmax = Math.max(lmax, height[i]);
                i++;
            } else {
                sum += height[j] < rmax ? rmax - height[j] : 0;
                rmax = Math.max(rmax, height[j]);
                j--;
            }
        }
        return sum;
    }
}


class OldestSolution {
    public int trap(int[] height) {
        final int n = height.length;
        int sum = 0;
        int l = 0, r = n - 1;
        int lmax = 0, rmax = 0;
        while (l <= r) {
            if (height[l] < height[r]) {
                sum += Math.max(lmax, height[l]) - height[l];
                lmax = Math.max(lmax, height[l]);
                l++;
            } else {
                sum += Math.max(rmax, height[r]) - height[r];
                rmax = Math.max(rmax, height[r]);
                r--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] h = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new BasicSolution().trap(h));
    }
}

class BasicSolution {
    public int trap(int[] height) {
        final int n = height.length;
        if (n <= 1) {
            return 0;
        }

        int max = 0;
        for (int i = 1; i < n; i++) {
            if (height[i] > height[max]) {
                max = i;
            }
        }

        int sum = 0;
        int lmax = 0;
        for (int i = 0; i < max; i++) {
            sum += Math.max(lmax, height[i]) - height[i];
            lmax = Math.max(lmax, height[i]);
        }

        int rmax = 0;
        for (int i = n - 1; i > max; i--) {
            sum += Math.max(rmax, height[i]) - height[i];
            rmax = Math.max(rmax, height[i]);
        }
        return sum;
    }
}

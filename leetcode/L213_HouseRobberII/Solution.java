package leetcode.L213_HouseRobberII;

public class Solution {
    private int rob(int[] nums, int s, int e) {
        int[] f = new int[2];
        for (int i = s; i <= e; i++) {
            f[i % 2] = Math.max(f[i % 2] + nums[i], f[1 - i % 2]);
        }

        return f[e % 2];
    }

    public int rob(int[] nums) {
        final int n = nums.length;
        if (n <= 1) {
            return n == 0 ? 0 : nums[0];
        }
        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }
}

class BasicSolution {
    private int rob(int[] nums, int s, int e) {
        int prev = 0, curr = 0;
        for (int i = s; i <= e; i++) {
            int tmp = curr;
            curr = Math.max(prev + nums[i], curr);
            prev = tmp;
        }

        return curr;
    }

    public int rob(int[] nums) {
        final int n = nums.length;
        if (n <= 1) {
            return n == 0 ? 0 : nums[0];
        }
        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }
}

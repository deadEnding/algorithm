package leetcode.L376_WiggleSubsequence;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 11:01 AM 12/18/16
 * @version: 1.0
 * @description:
 */

public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int f = 1, d = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                f = d + 1;
            } else if (nums[i] > nums[i - 1]) {
                d = f + 1;
            }
        }
        return Math.max(f, d);
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2};
        System.out.println(new DPSolution().wiggleMaxLength(nums));
    }
}

/**
 * 状态转移方程:
 * dp[i][0] = max{dp[j][1]} + 1,当 nums[i] > nums[j]
 * dp[i][1] = max{dp[j][0]} + 1,当 nums[i] < nums[j]
 * 时间复杂度: O(n^2)
 */
class DPSolution {
    public int wiggleMaxLength(int[] nums) {
        final int n = nums.length;
        if (n <= 1) {
            return n;
        }
        int[][] dp = new int[n + 1][2];

        int max = 1;
        for (int i = 0; i < n; i++) {
            dp[i + 1][0] = dp[i + 1][1] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i + 1][0] = Math.max(dp[i + 1][0], dp[j + 1][1] + 1);
                } else if (nums[i] < nums[j]) {
                    dp[i + 1][1] = Math.max(dp[i + 1][1], dp[j + 1][0] + 1);
                }
            }
            max = Math.max(max, Math.max(dp[i + 1][0], dp[i + 1][1]));
        }
        return max;
    }
}

/**
 * 使用栈模拟，当不能增长时，用新元素替换掉栈顶元素
 */
class BadSolution {
    private int wiggleMaxLength(int[] nums, boolean positive) {
        LinkedList<Integer> stack = new LinkedList<>();

        stack.push(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == stack.peek()) {
                continue;
            }
            if ((nums[i] > stack.peek()) == positive) {
                stack.push(nums[i]);
                positive = !positive;
            } else {
                stack.pop();
                stack.push(nums[i]);
            }
        }
        return stack.size();
    }

    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        return Math.max(wiggleMaxLength(nums, true), wiggleMaxLength(nums, false));
    }
}

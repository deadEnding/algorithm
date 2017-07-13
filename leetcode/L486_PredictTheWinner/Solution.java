package leetcode.L486_PredictTheWinner;

/**
 * @author: deadend
 * @date: 8:41 PM 2/4/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        final int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        int[][] max = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            max[i][i] = nums[i];
            for (int j = i + 1; j < n; j++) {
                max[i][j] = sum[j + 1] - sum[i] - Math.min(max[i + 1][j], max[i][j - 1]);
            }
        }
        return max[0][n - 1] * 2 >= sum[n];
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 233, 7};
        System.out.println(new Solution().PredictTheWinner(nums));
    }
}

class RecursionSolution {
    public boolean PredictTheWinner(int[] nums) {
        return helper(nums, 0, nums.length-1, new Integer[nums.length][nums.length])>=0;
    }
    private int helper(int[] nums, int s, int e, Integer[][] mem){
        if(mem[s][e]==null)
            mem[s][e] = s==e ? nums[e] : Math.max(nums[e]-helper(nums,s,e-1,mem),nums[s]-helper(nums,s+1,e,mem));
        return mem[s][e];
    }
}

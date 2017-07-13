package leetcode.again.L368_LargestDivisibleSubset;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 1:12 PM 3/1/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        LinkedList<Integer> set = new LinkedList<>();
        final int n = nums.length;
        if (n == 0) {
            return set;
        }

        Arrays.sort(nums);
        int[] dp = new int[n];
        int[] prev = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            prev[i] = -1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            max = dp[max] < dp[i] ? i : max;
        }

        for (int i = max; i != -1; i = prev[i]) {
            set.addFirst(nums[i]);
        }
        return set;
    }
}

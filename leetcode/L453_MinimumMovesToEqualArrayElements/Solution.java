package leetcode.L453_MinimumMovesToEqualArrayElements;

/**
 * @author: deadend
 * @date: P10:53 AM 3/2/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int minMoves(int[] nums) {
        if (nums.length == 0)
            return 0;
        long sum = 0;
        int min = Integer.MAX_VALUE;
        for (int num: nums) {
            sum += num;
            min = Math.min(min, num);
        }
        return (int) (sum - (long)min * nums.length);
    }
}

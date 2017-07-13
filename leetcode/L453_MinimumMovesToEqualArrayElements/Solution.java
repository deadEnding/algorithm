package leetcode.L453_MinimumMovesToEqualArrayElements;

import java.util.Arrays;

/**
 * @author: deadend
 * @date: P10:49 PM 12/23/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int minMoves(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int num : nums) {
            min = Math.min(min, num);
            sum += num;
        }
        return sum - nums.length * min;
    }
}

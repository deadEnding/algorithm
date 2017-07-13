package leetcode.L446_ArithmeticSlicesIISubsequence;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: 2:51 PM 2/18/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int count = 0;
        HashMap<Integer, Integer>[] maps = new HashMap[nums.length];
        for (int i = 0; i < nums.length; i++) {
            maps[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];
                if (diff < Integer.MIN_VALUE || diff > Integer.MAX_VALUE) {
                    continue;
                }

                int d = (int) diff;
                int c = maps[j].getOrDefault(d, 0);
                count += c;
                maps[i].put(d, maps[i].getOrDefault(d, 0) + c + 1); // 1对应的是nums[j]、nums[i]序列
            }
        }
        return count;
    }
}

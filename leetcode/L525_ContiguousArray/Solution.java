package leetcode.L525_ContiguousArray;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: 5:35 PM 2/20/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int findMaxLength(int[] nums) {
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] == 1 ? 1 : -1;
        }

        int max = 0;
        HashMap<Integer, Integer> sumIndex = new HashMap<>();
        sumIndex.put(0, -1);
        for (int i = 0, sum = 0; i < n; i++) {
            sum += nums[i];
            if (sumIndex.containsKey(sum)) {
                max = Math.max(max, i - sumIndex.get(sum));
            } else {
                sumIndex.put(sum, i);
            }
        }
        return max;
    }
}

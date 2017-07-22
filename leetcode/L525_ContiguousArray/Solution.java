package leetcode.L525_ContiguousArray;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: 10:57 AM 29/03/2017
 */


public class Solution {
    public int findMaxLength(int[] nums) {
        final int n = nums.length;

        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] == 0 ? -1 : 1;
        }

        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                max = Math.max(max, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return max;
    }
}

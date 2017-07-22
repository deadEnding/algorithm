package leetcode.again.L560_SubarraySumEqualsK;

import java.util.HashMap;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        counter.put(0, 1);

        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            count += counter.getOrDefault(sum - k, 0);
            counter.put(sum, counter.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}

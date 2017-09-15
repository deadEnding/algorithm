package leetcode.L325_MaximumSizeSubarraySumEqualsK;

import java.util.HashMap;

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        final int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0, max = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                max = Math.max(max, i - map.get(sum - k));
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, -1, 5, -2, 3};
        System.out.println(new Solution().maxSubArrayLen(nums, 3));
    }
}


package leetcode.L128_LongestConsecutiveSequence;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: deadend
 * @date: 1:01 PM 11/22/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, new int[]{n - 1, n + 1});
        }

        int max = 1;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int left = entry.getValue()[0];
            int right = entry.getValue()[1];
            if (map.containsKey(left)) {
                map.get(left)[1] = right;
            }
            if (map.containsKey(right)) {
                map.get(right)[0] = left;
            }
            max = Math.max(max, right - left - 1);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(new Solution().longestConsecutive(nums));
    }
}

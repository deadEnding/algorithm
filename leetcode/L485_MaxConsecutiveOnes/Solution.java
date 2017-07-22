package leetcode.L485_MaxConsecutiveOnes;

/**
 * @author: deadend
 * @date: 9:33 PM 3/14/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        for (int i = 0, cnt = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                cnt++;
            } else {
                cnt = 0;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}

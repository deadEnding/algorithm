package leetcode.L485_MaxConsecutiveOnes;

/**
 * @author: deadend
 * @date: 8:37 PM 2/4/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, tmp = 0;
        for (int n : nums) {
            if (n == 0) {
                tmp = 0;
            } else {
                tmp++;
            }
            max = Math.max(max, tmp);
        }
        return max;
    }
}

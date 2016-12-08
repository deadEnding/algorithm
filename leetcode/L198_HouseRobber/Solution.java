package leetcode.L198_HouseRobber;

/**
 * @author: deadend
 * @date: 2:52 PM 12/8/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int rob(int[] nums) {
        int prev = 0;
        int curr = 0;
        for (int num : nums) {
            int tmp = curr;
            curr = Math.max(curr, prev + num);
            prev = tmp;
        }

        return curr;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(new Solution().rob(nums));
    }
}

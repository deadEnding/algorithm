package leetcode.L477_TotalHammingDistance;

/**
 * @author: deadend
 * @date: 9:16 PM 12/24/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int totalHammingDistance(int[] nums) {
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            int c = 0;
            for (int n : nums) {
                c += (n >> i) & 1;
            }
            sum += c * (nums.length - c);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {4,14,2};
        System.out.println(new Solution().totalHammingDistance(nums));
    }
}

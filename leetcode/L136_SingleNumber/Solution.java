package leetcode.L136_SingleNumber;

/**
 * @author: deadend
 * @date: 8:41 PM 11/24/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for (int n : nums) {
            xor ^= n;
        }
        return xor;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,4,3,2,1};
        System.out.println(new Solution().singleNumber(nums));
    }
}

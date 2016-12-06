package leetcode.L260_SingleNumberIII;

/**
 * @author: deadend
 * @date: 2:59 PM 12/6/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int n : nums) {
            xor ^= n;
        }

        int bit = xor & (~(xor - 1));
        int[] singles = new int[2];
        for (int n : nums) {
            if ((n & bit) == 0) {
                singles[0] ^= n;
            } else {
                singles[1] ^= n;
            }
        }

        return singles;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,3,4,4};
        int[] singles = new Solution().singleNumber(nums);
        System.out.println(singles[0] + " " + singles[1]);
    }
}

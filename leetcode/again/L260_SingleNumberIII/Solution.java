package leetcode.again.L260_SingleNumberIII;

/**
 * @author: deadend
 * @date: 7:23 PM 2/28/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        int bit = (~(xor - 1)) & xor;
        int[] result = new int[2];
        for (int num : nums) {
            if ((num & bit) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        return result;
    }
}

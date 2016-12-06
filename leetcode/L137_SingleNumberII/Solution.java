package leetcode.L137_SingleNumberII;

/**
 * @author: deadend
 * @date: 2:27 PM 12/6/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int singleNumber(int[] nums) {
        final int SIZE = 32;
        int[] bits = new int[SIZE];

        int once = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int n : nums) {
                bits[i] += (n >> i) & 1;
            }
            once += (bits[i] % 3) << i;
        }

        return once;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,1,1};
        System.out.println(new Solution().singleNumber(nums));
    }
}

package leetcode.L338_CountingBits;

/**
 * @author: deadend
 * @date: 3:51 PM 12/16/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int[] countBits(int num) {
        int[] counter = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            counter[i] = counter[i >> 1] + i % 2;
        }
        return counter;
    }
}

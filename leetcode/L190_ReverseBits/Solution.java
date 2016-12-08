package leetcode.L190_ReverseBits;

/**
 * @author: deadend
 * @date: 9:22 AM 12/8/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int rn = 0;
        for (int i = 0; i < 32; i++) {
            rn = (rn << 1) + ((n >> i) & 1);
        }
        return rn;
    }
}

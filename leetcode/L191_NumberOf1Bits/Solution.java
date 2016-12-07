package leetcode.L191_NumberOf1Bits;

/**
 * @author: deadend
 * @date: 10:59 PM 12/7/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int weight = 0;
        for (int i = 0; i < 32; i++) {
            weight += (n >> i) & 1;
        }
        return weight;
    }
}

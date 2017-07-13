package leetcode.again.L191_NumberOf1Bits;


public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return n == 0 ? 0 : hammingWeight(n >>> 1) + (n & 1);
    }
}

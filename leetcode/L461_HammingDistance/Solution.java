package leetcode.L461_HammingDistance;

/**
 * @author: deadend
 * @date: 3:06 PM 12/24/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}

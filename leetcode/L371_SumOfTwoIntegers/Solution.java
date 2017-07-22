package leetcode.L371_SumOfTwoIntegers;

/**
 * @author: deadend
 * @date: 2:00 PM 3/1/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }
}

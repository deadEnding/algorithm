package leetcode.L258_AddDigits;

/**
 * @author: deadend
 * @date: 11:31 PM 12/10/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int addDigits(int num) {
        return num % 9 == 0 ? num == 0 ? 0 : 9 : num % 9;
    }
}

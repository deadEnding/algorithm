package leetcode.L370_RangeAddition;

/**
 * @author: deadend
 * @date: 9:19 AM 3/15/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        for (int[] ud : updates) {
            result[ud[0]] += ud[2];
            if (ud[1] + 1 < length) {
                result[ud[1] + 1] -= ud[2];
            }
        }

        for (int i = 0, sum = 0; i < length; i++) {
            sum += result[i];
            result[i] = sum;
        }
        return result;
    }
}

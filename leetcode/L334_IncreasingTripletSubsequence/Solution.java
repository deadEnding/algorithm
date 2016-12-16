package leetcode.L334_IncreasingTripletSubsequence;

/**
 * @author: deadend
 * @date: 2:37 PM 12/16/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n <= min) {
                min = n;
            } else if (n <= secondMin) {
                secondMin = n;
            } else {
                return true;
            }
        }
        return false;
    }
}

package leetcode.L334_IncreasingTripletSubsequence;

import java.util.Arrays;

/**
 * @author: deadend
 * @date: 12:03 PM 3/1/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= firstMin) {
                firstMin = num;
            } else if (num <= secondMin) {
                secondMin = num;
            } else {
                return true;
            }
        }
        return false;
    }
}

class BasicSolution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        int ix = 0;
        int[] subSeqMax = new int[2];
        for (int num : nums) {
            int i = Arrays.binarySearch(subSeqMax, 0, ix, num);
            i = i >= 0 ? i : -(i + 1);
            if (i == 2) {
                return true;
            }

            subSeqMax[i] = num;
            if (i == ix) {
                ix++;
            }
        }
        return false;
    }
}

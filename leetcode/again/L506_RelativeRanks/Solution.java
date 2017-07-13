package leetcode.again.L506_RelativeRanks;

import java.util.Arrays;

/**
 * @author: deadend
 * @date: 6:36 PM 28/03/2017
 */


public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        final int n = nums.length;
        int[][] tmp = new int[n][2];
        for (int i = 0; i < n; i++) {
            tmp[i][0] = nums[i];
            tmp[i][1] = i;
        }

        Arrays.sort(tmp, (i1, i2) -> (i2[0] - i1[0]));

        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                result[tmp[i][1]] = "Gold Medal";
            } else if (i == 1) {
                result[tmp[i][1]] = "Silver Medal";
            } else if (i == 2) {
                result[tmp[i][1]] = "Bronze Medal";
            } else {
                result[tmp[i][1]] = String.valueOf(i + 1);
            }
        }
        return result;
    }
}

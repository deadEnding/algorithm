package leetcode.L548_SplitArrayWithEqualSum;

import java.util.HashSet;

/**
 * @author: deadend
 * @date: 10:21 AM 03/04/2017
 */


public class Solution {
    public boolean splitArray(int[] nums) {
        final int n = nums.length;
        if (n < 7) {
            return false;
        }

        int[] sum = new int[n];
        for (int i = 0; i < n; i++) {
            sum[i] = (i == 0 ? 0 : sum[i - 1]) + nums[i];
        }

        for (int j = 3; j < n - 3; j++) {
            HashSet<Integer> set = new HashSet<>();
            for (int i = 1; i < j - 1; i++) {
                if (sum[i - 1] == sum[j - 1] - sum[i]) {
                    set.add(sum[i - 1]);
                }
            }

            for (int k = j + 2; k < n - 1; k++) {
                if (sum[k - 1] - sum[j] == sum[n - 1] - sum[k] && set.contains(sum[k - 1] - sum[j])) {
                    return true;
                }
            }
        }
        return false;
    }
}

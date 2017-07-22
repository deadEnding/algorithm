package leetcode.L274_HIndex;

import java.util.Arrays;

/**
 * @author: deadend
 * @date: 2:49 PM 3/15/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int hIndex(int[] citations) {
        final int n = citations.length;
        Arrays.sort(citations);
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n - i) {
                return n - i;
            }
        }
        return 0;
    }
}

package leetcode.again.L228_SummaryRanges;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 9:27 PM 3/15/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public List<String> summaryRanges(int[] nums) {
        final int n = nums.length;
        List<String> result = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            StringBuffer buffer = new StringBuffer();
            int j = i;
            while (i + 1 < n && nums[i + 1] == nums[i] + 1) {
                i++;
            }

            buffer.append(nums[j]);
            if (j != i) {
                buffer.append("->" + nums[i]);
            }
            result.add(buffer.toString());
        }
        return result;
    }
}

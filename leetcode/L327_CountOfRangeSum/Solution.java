package leetcode.L327_CountOfRangeSum;

import java.util.Arrays;

/**
 * @author: deadend
 * @date: 4:28 PM 2/16/17
 * @version: 1.0
 * @description:
 */


public class Solution {

    private int merge(long[] sums, int s, int m, int e, int lower, int upper) {
        int total = 0;
        long[] tmp = new long[e - s + 1];
        int js = m + 1, je = m + 1, j = m + 1, ix = 0;
        for (int i = s; i <= m; i++) {
            while (js <= e && sums[js] - sums[i] < lower) {   // 第一个左入界
                js++;
            }
            while (je <= e && sums[je] - sums[i] <= upper) {  // 第一个右出界
                je++;
            }
            total += je - js;
            while (j <= e && sums[j] < sums[i]) {
                tmp[ix++] = sums[j++];
            }
            tmp[ix++] = sums[i];
        }
        System.arraycopy(tmp, 0, sums, s, j - s);
        return total;
    }

    private int countRangeSum(long[] sums, int s, int e, int lower, int upper) {
        if (s >= e) {   // s == e时也是0，e = s + 1时表示有1个元素nums[e]
            return 0;
        }

        int mid = s + (e - s) / 2;
        return countRangeSum(sums, s, mid, lower, upper) + countRangeSum(sums, mid + 1, e, lower, upper) +
                merge(sums, s, mid, e, lower, upper);
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        final int n = nums.length;
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        return countRangeSum(sums, 0, sums.length - 1, lower, upper);
    }

    public static void main(String[] args) {
        int[] nums = {-2,5,  -1};
        int lower = -2;
        int upper = 2;
        System.out.println(new Solution().countRangeSum(nums, lower, upper));
    }
}

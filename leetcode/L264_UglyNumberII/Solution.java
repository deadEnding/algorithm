package leetcode.L264_UglyNumberII;

/**
 * @author: deadend
 * @date: 4:17 PM 12/11/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int nthUglyNumber(int n) {
        int[] nums = new int[n + 1];
        nums[1] = 1;
        for (int ix = 2, i = 1, j = 1, k = 1; ix <= n; ix++) {
            int vi = nums[i] * 2;
            int vj = nums[j] * 3;
            int vk = nums[k] * 5;
            nums[ix] = Math.min(Math.min(vi, vj), vk);
            i = nums[ix] == vi ? i + 1 : i;
            j = nums[ix] == vj ? j + 1 : j;
            k = nums[ix] == vk ? k + 1 : k;
        }
        return nums[n];
    }
}

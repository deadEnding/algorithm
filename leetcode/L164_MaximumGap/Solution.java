package leetcode.L164_MaximumGap;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 5:02 PM 12/7/16
 * @version: 1.0
 * @description:
 */

// 基数排序
public class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        LinkedList<Integer>[] buckets = new LinkedList[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }

        for (int i = 0, exp = 1; i < 10; i++, exp *= 10) {

            for (int n : nums) {
                buckets[n / exp % 10].offer(n);
            }

            for (int j = 0, k = 0; j < buckets.length; j++) {
                while (!buckets[j].isEmpty()) {
                    nums[k++] = buckets[j].poll();
                }
            }
        }

        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i] - nums[i - 1]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 9};
        System.out.println(new Solution().maximumGap(nums));
    }
}
